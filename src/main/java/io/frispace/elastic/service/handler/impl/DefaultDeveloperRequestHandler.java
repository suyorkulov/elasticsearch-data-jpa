package io.frispace.elastic.service.handler.impl;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.domain.request.AddDeveloperRequest;
import io.frispace.elastic.domain.request.DeveloperSearchRequest;
import io.frispace.elastic.dto.developer.AddDeveloperRequestDto;
import io.frispace.elastic.dto.developer.AddDeveloperSkillsRequestDto;
import io.frispace.elastic.dto.developer.DeveloperDto;
import io.frispace.elastic.dto.developer.DeveloperSearchRequestDto;
import io.frispace.elastic.dto.paging.PageResponseDto;
import io.frispace.elastic.service.domain.DeveloperService;
import io.frispace.elastic.service.domain.SkillService;
import io.frispace.elastic.service.handler.DeveloperRequestHandler;
import io.frispace.elastic.service.mapper.DeveloperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author esuyorkulov.
 */
@Service
public class DefaultDeveloperRequestHandler implements DeveloperRequestHandler {

    private final DeveloperService developerService;
    private final SkillService skillService;
    private final DeveloperMapper developerMapper;

    @Autowired
    public DefaultDeveloperRequestHandler(DeveloperService developerService,
                                          SkillService skillService,
                                          DeveloperMapper developerMapper) {
        this.developerService = developerService;
        this.skillService = skillService;
        this.developerMapper = developerMapper;
    }

    @Override
    @Transactional
    public DeveloperDto add(AddDeveloperRequestDto request) {
        List<Skill> developerSkills = getSkills(request.getSkills());
        AddDeveloperRequest domainRequest = new AddDeveloperRequest();
        domainRequest.setFirstName(request.getFirstName());
        domainRequest.setLastName(request.getLastName());
        domainRequest.setPosition(request.getPosition());
        domainRequest.setSkills(developerSkills);
        Developer persistedDeveloper = developerService.save(domainRequest);
        return developerMapper.toDto(persistedDeveloper);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponseDto findAll(DeveloperSearchRequestDto searchRequest) {
        DeveloperSearchRequest developerSearchRequest = new DeveloperSearchRequest(searchRequest.getText());
        Page<Developer> developers = developerService.findAll(developerSearchRequest);
        return new PageResponseDto(
                developers.getSize(),
                developers.stream()
                        .map(developerMapper::toDto)
                        .collect(Collectors.toList()));
    }

    private List<Skill> getSkills(List<AddDeveloperSkillsRequestDto> skills) {
        return skills.stream()
                .map(request -> getSkill(request.getName()))
                .collect(Collectors.toList());
    }

    private Skill getSkill(String name) {
        Skill skill = skillService.findSkill(name);
        return null == skill ? skillService.add(name) : skill;
    }
}

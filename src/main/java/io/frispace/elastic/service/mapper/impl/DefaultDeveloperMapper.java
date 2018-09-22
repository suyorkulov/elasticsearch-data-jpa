package io.frispace.elastic.service.mapper.impl;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.dto.developer.DeveloperDto;
import io.frispace.elastic.dto.developer.SkillDto;
import io.frispace.elastic.service.mapper.DeveloperMapper;
import io.frispace.elastic.service.mapper.SkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author esuyorkulov.
 */
@Service
public class DefaultDeveloperMapper implements DeveloperMapper {

    private final SkillMapper skillMapper;

    @Autowired
    public DefaultDeveloperMapper(SkillMapper skillMapper) {
        this.skillMapper = skillMapper;
    }

    @Override
    public DeveloperDto toDto(@NonNull Developer developer) {
        DeveloperDto developerDto = new DeveloperDto();
        List<SkillDto> skills = developer.getSkills()
                .stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
        developerDto.setId(developer.getId());
        developerDto.setFirstName(developer.getFirstName());
        developerDto.setLastName(developer.getLastName());
        developerDto.setPosition(developer.getPosition());
        developerDto.setSkills(skills);
        return developerDto;
    }
}

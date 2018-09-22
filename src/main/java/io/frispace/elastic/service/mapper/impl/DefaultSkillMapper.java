package io.frispace.elastic.service.mapper.impl;

import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.dto.developer.SkillDto;
import io.frispace.elastic.service.mapper.SkillMapper;
import org.springframework.stereotype.Service;

/**
 * @author esuyorkulov.
 */
@Service
public class DefaultSkillMapper implements SkillMapper {

    @Override
    public SkillDto toDto(Skill skill) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        return skillDto;
    }
}

package io.frispace.elastic.service.mapper;

import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.dto.developer.SkillDto;

/**
 * @author esuyorkulov.
 */
public interface SkillMapper {
    SkillDto toDto(Skill skill);
}

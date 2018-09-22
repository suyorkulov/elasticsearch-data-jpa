package io.frispace.elastic.service.domain;

import io.frispace.elastic.domain.Skill;

/**
 * @author esuyorkulov.
 */
public interface SkillService {
    Skill findSkill(String name);
    Skill add(String name);
}

package io.frispace.elastic.service.domain.impl;

import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.index.ElasticSkillRepository;
import io.frispace.elastic.repository.SkillRepository;
import io.frispace.elastic.service.domain.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author esuyorkulov.
 */
@Service
public class DefaultSkillService implements SkillService {

    private final SkillRepository skillRepository;
    private final ElasticSkillRepository elasticSkillRepository;

    @Autowired
    public DefaultSkillService(SkillRepository skillRepository,
                               ElasticSkillRepository elasticSkillRepository) {
        this.skillRepository = skillRepository;
        this.elasticSkillRepository = elasticSkillRepository;
    }

    @Override
    public Skill findSkill(String name) {
        return elasticSkillRepository.findByName(name);
    }

    @Override
    public Skill add(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        return skillRepository.save(skill);
    }
}

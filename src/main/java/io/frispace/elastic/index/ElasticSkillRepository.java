package io.frispace.elastic.index;

import io.frispace.elastic.domain.Skill;
import org.springframework.stereotype.Repository;

/**
 * @author esuyorkulov.
 */
@Repository
public interface ElasticSkillRepository extends BaseElasticSearchRepository<Skill> {
    Skill findByName(String name);
}

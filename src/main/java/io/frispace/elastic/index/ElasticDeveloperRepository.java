package io.frispace.elastic.index;

import io.frispace.elastic.domain.Developer;
import org.springframework.stereotype.Repository;

/**
 * @author esuyorkulov.
 */
@Repository
public interface ElasticDeveloperRepository extends BaseElasticSearchRepository<Developer> {
}

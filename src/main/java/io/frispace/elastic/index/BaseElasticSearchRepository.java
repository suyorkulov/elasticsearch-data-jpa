package io.frispace.elastic.index;

import io.frispace.elastic.domain.BaseEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author esuyorkulov.
 */
@NoRepositoryBean
public interface BaseElasticSearchRepository<T extends BaseEntity> extends ElasticsearchRepository<T, Long> {

}
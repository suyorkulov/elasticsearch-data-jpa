package io.frispace.elastic.common.component;

import io.frispace.elastic.domain.BaseEntity;
import io.frispace.elastic.exception.ElasticActivityException;
import io.frispace.elastic.index.BaseElasticSearchRepository;
import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import java.util.Map;

/**
 * @author esuyorkulov.
 */
@Component
public class ElasticActivityListener<T extends BaseEntity> implements ApplicationContextAware {

    private static ApplicationContext appContext;
    private BaseElasticSearchRepository<T> repository;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    @PostPersist
    @PostUpdate
    public void save(@NonNull T t) {
        repository = getElasticRepository(t);
        repository.save(t);
    }

    @PostRemove
    public void remove(@NonNull T t) {
        repository = getElasticRepository(t);
        repository.delete(t);
    }

    private BaseElasticSearchRepository getElasticRepository(T t) {
        Class entityClass = t.getClass();
        Map<String, BaseElasticSearchRepository> elasticRepositories
                = appContext.getBeansOfType(BaseElasticSearchRepository.class);
        return elasticRepositories.values()
                .stream()
                .filter(elasticRepository -> elasticRepository.getEntityClass().equals(entityClass))
                .findFirst()
                .orElseThrow(() -> new ElasticActivityException(entityClass));
    }
}

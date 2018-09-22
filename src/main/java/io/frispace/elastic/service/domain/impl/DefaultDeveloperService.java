package io.frispace.elastic.service.domain.impl;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.domain.request.AddDeveloperRequest;
import io.frispace.elastic.domain.request.DeveloperSearchRequest;
import io.frispace.elastic.index.ElasticDeveloperRepository;
import io.frispace.elastic.repository.DeveloperRepository;
import io.frispace.elastic.service.domain.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * @author esuyorkulov.
 */
@Service
public class DefaultDeveloperService implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final ElasticDeveloperRepository elasticDeveloperRepository;

    @Autowired
    public DefaultDeveloperService(DeveloperRepository developerRepository,
                                   ElasticDeveloperRepository elasticDeveloperRepository) {
        this.developerRepository = developerRepository;
        this.elasticDeveloperRepository = elasticDeveloperRepository;
    }

    @Override
    @Transactional
    public Developer save(AddDeveloperRequest request) {
        Developer developer = new Developer();
        developer.setFirstName(request.getFirstName());
        developer.setLastName(request.getLastName());
        developer.setPosition(request.getPosition());
        developer.setSkills(request.getSkills());
        return developerRepository.save(developer);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Developer> findAll(DeveloperSearchRequest searchRequest) {
        return elasticDeveloperRepository.search(queryStringQuery(searchRequest.getText()), Pageable.unpaged());
    }
}

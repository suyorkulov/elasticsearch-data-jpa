package io.frispace.elastic.service.domain;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.domain.request.AddDeveloperRequest;
import io.frispace.elastic.domain.request.DeveloperSearchRequest;
import org.springframework.data.domain.Page;

/**
 * @author esuyorkulov.
 */
public interface DeveloperService {
    Developer save(AddDeveloperRequest request);

    Page<Developer> findAll(DeveloperSearchRequest searchRequest);
}

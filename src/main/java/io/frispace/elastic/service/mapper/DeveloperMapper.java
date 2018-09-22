package io.frispace.elastic.service.mapper;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.dto.developer.DeveloperDto;

/**
 * @author esuyorkulov.
 */
public interface DeveloperMapper {
    DeveloperDto toDto(Developer developer);
}

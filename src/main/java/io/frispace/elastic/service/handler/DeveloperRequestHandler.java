package io.frispace.elastic.service.handler;

import io.frispace.elastic.dto.developer.AddDeveloperRequestDto;
import io.frispace.elastic.dto.developer.DeveloperDto;
import io.frispace.elastic.dto.developer.DeveloperSearchRequestDto;
import io.frispace.elastic.dto.paging.PageResponseDto;

/**
 * @author esuyorkulov.
 */
public interface DeveloperRequestHandler {
    DeveloperDto add(AddDeveloperRequestDto request);

    PageResponseDto findAll(DeveloperSearchRequestDto developerSearchRequestDto);
}

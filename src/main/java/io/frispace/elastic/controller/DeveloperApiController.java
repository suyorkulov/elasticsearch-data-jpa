package io.frispace.elastic.controller;

import io.frispace.elastic.dto.developer.AddDeveloperRequestDto;
import io.frispace.elastic.dto.developer.DeveloperDto;
import io.frispace.elastic.dto.developer.DeveloperSearchRequestDto;
import io.frispace.elastic.dto.paging.PageResponseDto;
import io.frispace.elastic.service.handler.DeveloperRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author esuyorkulov.
 */

@RestController
@RequestMapping("/api/developers")
public class DeveloperApiController {

    private final DeveloperRequestHandler requestHandler;

    @Autowired
    public DeveloperApiController(DeveloperRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @PostMapping
    public DeveloperDto add(@Valid @RequestBody AddDeveloperRequestDto request) {
        return requestHandler.add(request);
    }

    @GetMapping
    public PageResponseDto find(@Valid DeveloperSearchRequestDto searchRequest) {
        return requestHandler.findAll(searchRequest);
    }
}

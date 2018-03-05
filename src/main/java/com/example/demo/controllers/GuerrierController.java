package com.example.demo.controllers;

import com.example.demo.model.Guerrier;
import com.example.demo.model.GuerrierEvent;
import com.example.demo.services.GuerrierService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("v1")
public class GuerrierController {


    private final GuerrierService service;

    public GuerrierController(GuerrierService service) {
        this.service = service;
    }

    @GetMapping(value = "/guerriers",  produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Guerrier> listAllGerriers() {

        return service.findAll();
    }

    @GetMapping("/guerriers/{id}")
    public Mono<Guerrier> findById(@PathVariable String id) {

        return service.findById(id);
    }

    @GetMapping(value = "/guerriers/{id}/events", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<GuerrierEvent> guerrierEvent(@PathVariable String id) {

        return service.createEvents(id);
    }
}

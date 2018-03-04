package com.example.demo.services;

import com.example.demo.model.Guerrier;
import com.example.demo.model.GuerrierEvent;
import com.example.demo.repositories.GuerrierRepository;
import com.example.demo.stream.publishers.GuerrierPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableBinding(Processor.class)
public class GuerrierService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuerrierService.class);

    private final GuerrierRepository repo;

    private final GuerrierPublisher publisher;

    public GuerrierService(GuerrierRepository repo, GuerrierPublisher publisher) {
        this.repo = repo;
        this.publisher = publisher;
    }

    public Flux<Guerrier> findAll() {
        return Flux.fromIterable(repo.findAll());
    }

    public void save(Guerrier g) {
        LOGGER.info("adding new guerrire '{}' into database", g.getName());
        repo.save(g);
        publisher.publish(g);
    }

    public Mono<Guerrier> findById(String id) {
        return Mono.justOrEmpty(repo.findById(id));
    }

    public Flux<GuerrierEvent> createEvents(String id) {

      return Flux.generate((SynchronousSink<GuerrierEvent> sink) -> sink.next(new GuerrierEvent(id, LocalDateTime.now())))
                .delayElements(Duration.ofSeconds(1L));
    }
}

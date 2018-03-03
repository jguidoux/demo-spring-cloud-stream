package com.example.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableBinding(Processor.class)
public class GuerrierService {

    private final GuerrierRepository repo;

    private  final Source mysource;
    public GuerrierService(GuerrierRepository repo, Source mysource) {
        this.repo = repo;
        this.mysource = mysource;
    }

    public List<Guerrier> findAll() {
        return repo.findAll();
    }

    //@SendTo(Processor.OUTPUT)
    public Guerrier save(Guerrier g) {
        repo.save(g);
        mysource.output().send(MessageBuilder.withPayload(g).build());
        return g;
    }
}

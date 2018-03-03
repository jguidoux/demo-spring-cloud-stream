package com.example.demo.services;

import com.example.demo.model.Guerrier;
import com.example.demo.repositories.GuerrierRepository;
import com.example.demo.stream.publishers.GuerrierPublisher;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableBinding(Processor.class)
public class GuerrierService {

    private final GuerrierRepository repo;

    private  final GuerrierPublisher publisher;
    public GuerrierService(GuerrierRepository repo, GuerrierPublisher publisher) {
        this.repo = repo;
        this.publisher = publisher;
    }

    public List<Guerrier> findAll() {
        return repo.findAll();
    }

    public void save(Guerrier g) {
        repo.save(g);
        publisher.publish(g);
    }
}

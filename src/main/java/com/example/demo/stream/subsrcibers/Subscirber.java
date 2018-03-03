package com.example.demo.stream.subsrcibers;

import com.example.demo.model.Guerrier;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class Subscirber {


    @StreamListener
    public void printMessage(@Input(Processor.INPUT) Flux<Guerrier> guerriers) {
        System.out.println();
        guerriers.subscribe(System.out::println);
    }
}

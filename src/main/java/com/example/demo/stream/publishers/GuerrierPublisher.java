package com.example.demo.stream.publishers;

import com.example.demo.model.Guerrier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Processor.class)
public class GuerrierPublisher {

    private  final Source mysource;


    public GuerrierPublisher(Source mysource) {
        this.mysource = mysource;
    }

    public void publish(Guerrier guerrier) {
        mysource.output().send(MessageBuilder.withPayload(guerrier).build());

    }
}

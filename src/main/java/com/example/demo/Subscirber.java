package com.example.demo;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

@Service
public class Subscirber {


    @StreamListener(Processor.INPUT)
    public void  printMessage(Guerrier guerrier) {
        System.out.println();
        System.out.println(guerrier);
    }
}

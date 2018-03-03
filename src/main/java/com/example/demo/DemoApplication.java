package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private GuerrierService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner sampleCommandLineRunner() {
        return (args) -> Flux.fromArray("jeremie raph, laurent, pierre, jc, ronan".split(" "))
                .delayElements(Duration.ofSeconds(2))
                .map(name -> new Guerrier(name, 2))
                .subscribe(g -> service.save(g));
    }

}

package com.example.demo;

import com.example.demo.model.Guerrier;
import com.example.demo.services.GuerrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner sampleCommandLineRunner(GuerrierService service) {
        return (args) -> Flux.just("jeremie", " raph", "laurent", "pierre", "jc", "ronan")
                .delayElements(Duration.ofSeconds(2))
                .map(name -> new Guerrier(name, 2))
                .subscribe(service::save);
    }

}

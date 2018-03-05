package com.example.demo

import com.example.demo.model.Guerrier
import com.example.demo.services.GuerrierService
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux
import java.time.Duration


@SpringBootApplication
class DemoApplication {


    @Bean
    fun runner(service: GuerrierService) = ApplicationRunner {
        Flux.just("jeremie", " raph", "laurent", "pierre", "jc", "ronan")
                .delayElements(Duration.ofSeconds(2))
                .map { name -> Guerrier(name, 2) }
                .subscribe({ service.save(it) })
    }



}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}


package com.example.demo.controllers

import com.example.demo.model.Guerrier
import com.example.demo.model.GuerrierEvent
import com.example.demo.services.GuerrierService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class GuerrierRestAPI(val guerrierService: GuerrierService) {


    @Bean
    fun routes() = router {
        println()
        println("==============================================================")
        println("launchinG rest api")
        println("==============================================================")
        println()



        "/v2".nest {
            GET("/guerriers", {
                ServerResponse.ok().body(guerrierService.findAll(), Guerrier::class.java)
            })
            GET("/guerriers/{id}", {
                ServerResponse.ok().body(guerrierService.findById(it.pathVariable("id")), Guerrier::class.java)
            })
            GET("/guerriers/{id}/events", {
                ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(guerrierService.createEvents(it.pathVariable("id")), GuerrierEvent::class.java)
            })
        }

    }
}
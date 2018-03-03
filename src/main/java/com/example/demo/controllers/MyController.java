package com.example.demo.controllers;

import com.example.demo.model.Guerrier;
import com.example.demo.services.GuerrierService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {


    private final GuerrierService service;

    public MyController(GuerrierService service) {
        this.service = service;
    }

    @GetMapping("/name")
    public List<Guerrier> name(@RequestParam String value) {

        return service.findAll();
    }
}

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MyController {


    private final GuerrierRepository repo;

    public MyController(GuerrierRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/name")
    public List<Guerrier> name(@RequestParam String value) {

        return repo.findAll();
    }
}

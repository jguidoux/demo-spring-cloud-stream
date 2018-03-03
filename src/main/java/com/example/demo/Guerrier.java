package com.example.demo;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Guerrier {


    private  Long id;
    private String name;
    private int level;

    public Guerrier() {
    }


    public Guerrier(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public Guerrier(Long id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }


}

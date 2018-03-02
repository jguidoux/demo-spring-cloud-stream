package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication  {

	@Autowired
	private GuerrierRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Bean
	CommandLineRunner sampleCommandLineRunner() {
		return (args) -> Stream.of("jeremie raph".split(" "))
				.map(name ->new Guerrier(name, 2))
				.forEach(g -> repo.save(g));
	}

}

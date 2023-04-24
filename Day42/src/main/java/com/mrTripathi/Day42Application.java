package com.mrTripathi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class Day42Application {

	public static void main(String[] args) {
		SpringApplication.run(Day42Application.class, args);
	}

}

package com.mrTripathi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableDiscoveryClient
@EnableFeignClients
public class Day42Application {

	public static void main(String[] args) {
		SpringApplication.run(Day42Application.class, args);
	}

}

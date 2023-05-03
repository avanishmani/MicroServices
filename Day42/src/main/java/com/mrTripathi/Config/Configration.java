package com.mrTripathi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configration {
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}

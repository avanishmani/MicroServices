package com.mrTripathi.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mrTripathi.model.Hotel;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {
	@GetMapping("/hotel/{id}")
	Hotel getHotel(@PathVariable("id") Integer id);

	@GetMapping("/hotel")
	Hotel getHotel();

	@PostMapping("/hotel")
	Hotel createHotel(Hotel values);
}

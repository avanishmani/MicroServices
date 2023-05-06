package com.mrTripathi.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mrTripathi.model.Rating;

@FeignClient("RATING-SERVICE")
public interface RatingService {
	@GetMapping("ratings/user/{RatingID}")
	Rating[] getRatingByUserID(@PathVariable("RatingID") Integer RatingID);

	@GetMapping("ratings/hotel/{HID}")
	Rating getRatingByHotelID(@PathVariable("HID") Integer HID);

	@GetMapping("ratings")
	Rating getRating();

	@PostMapping("ratings")
	Rating createRating(Rating values);
}

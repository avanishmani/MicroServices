package com.mrTripathi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrTripathi.Exception.RatingException;
import com.mrTripathi.Service.RatingService;
import com.mrTripathi.Service.RatingServiceImpl;
import com.mrTripathi.model.Rating;


@RestController

public class RatingController {

	@Autowired
	private RatingService rs;
	@PostMapping("/ratings")
	public ResponseEntity<Rating> addRating (@RequestBody Rating r){
		Rating rating=rs.createRating(r);
		return new ResponseEntity<Rating>(rating,HttpStatus.CREATED);
	}
	@GetMapping("/ratings")
	public ResponseEntity<List<Rating>> getAllRating() throws RatingException{
		return new ResponseEntity<List<Rating>>(rs.getRating(),HttpStatus.OK);
	}
	@GetMapping("/ratings/user/{UID}")
	public ResponseEntity<List<Rating>> getAllRatingByUser(@PathVariable Integer UID) throws RatingException{
		return new ResponseEntity<List<Rating>>(rs.getRatingByUserID(UID),HttpStatus.OK);
	}
	@GetMapping("/ratings/hotel/{HID}")
	public ResponseEntity<List<Rating>> getAllRatingForHotel(@PathVariable Integer HID) throws RatingException{
		return new ResponseEntity<List<Rating>>(rs.getRatingByHotelID(HID),HttpStatus.OK);
	}
}

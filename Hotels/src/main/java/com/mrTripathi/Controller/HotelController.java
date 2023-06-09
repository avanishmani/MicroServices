package com.mrTripathi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrTripathi.Exception.HotelException;

import com.mrTripathi.Service.HotelServiceImpl;
import com.mrTripathi.model.Hotel;



@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelServiceImpl hs;

	@PostMapping("/add")
	public ResponseEntity<Hotel> addHotel(@org.springframework.web.bind.annotation.RequestBody Hotel hotel) {
		Hotel h1=hs.addHotel(hotel);
		System.out.println(h1+"**");
		return new ResponseEntity<Hotel>(h1, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> addHotel(@PathVariable Integer id) throws HotelException {
		return new ResponseEntity<Hotel>(hs.getHotel(id), HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Hotel>> addHotel() {
		return new ResponseEntity<List<Hotel>>(hs.getAllHotel(), HttpStatus.OK);
	}
	
	
}

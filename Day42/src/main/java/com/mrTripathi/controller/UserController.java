package com.mrTripathi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrTripathi.Exception.UserException;
import com.mrTripathi.Service.UserServiceImpl;
import com.mrTripathi.model.Users;

@RestController
public class UserController {
	@Autowired
	private UserServiceImpl usp;

	@PostMapping("/user")
	public ResponseEntity<Users> saveUser(@RequestBody Users user) {
		Users u = usp.saveUser(user);
		return new ResponseEntity<Users>(u, HttpStatus.ACCEPTED);
	}

	@GetMapping("/user/{user}")
	public ResponseEntity<Users> getUser(@PathVariable("user") String userID) throws UserException{
		Users u1=usp.getUser(userID);
		return new ResponseEntity<Users>(u1, HttpStatus.ACCEPTED);
	}
	@GetMapping("/user")
	public ResponseEntity<List<Users>> getUsers() {
		
		return new ResponseEntity<List<Users>>(usp.getAllUser(), HttpStatus.ACCEPTED);
	}
}

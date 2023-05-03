package com.mrTripathi.model;

import lombok.Data;

@Data
public class Rating {
	private Integer RatingID;
	private Integer userID;
	private Integer hotelID;
	private Integer Rating;
	private String Feedback;
	private Hotel hotel;
}

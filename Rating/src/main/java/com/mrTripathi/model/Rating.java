package com.mrTripathi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer RatingID;
	private Integer userID;
	private Integer hotelID;
	private Integer Rating;
	private String Feedback;
}

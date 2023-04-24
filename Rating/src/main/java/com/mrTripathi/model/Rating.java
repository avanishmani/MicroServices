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
	private Integer UserID;
	private Integer HotelID;
	private Integer Rating;
	private String Feedback;
}

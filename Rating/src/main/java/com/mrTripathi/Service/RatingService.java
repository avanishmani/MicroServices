package com.mrTripathi.Service;

import java.util.List;

import com.mrTripathi.Exception.RatingException;
import com.mrTripathi.model.Rating;

public interface RatingService {
	Rating createRating(Rating r);

	List<Rating> getRating() throws RatingException;

//	List<Rating> getRatingByUserID(Integer UID) throws RatingException;
//
//	List<Rating> getRatingByHotelID(Integer HID) throws RatingException;
}

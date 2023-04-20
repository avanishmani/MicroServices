package com.mrTripathi.Service;

import java.util.List;

import com.mrTripathi.Exception.HotelException;
import com.mrTripathi.model.Hotel;

public interface HotelService {
	Hotel addHotel(Hotel hotel);

	List<Hotel> getAllHotel();

	Hotel getHotel(Integer id) throws HotelException;
	
	
}

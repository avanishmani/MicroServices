package com.mrTripathi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mrTripathi.Exception.HotelException;
import com.mrTripathi.Repository.HotelRepository;
import com.mrTripathi.model.Hotel;

public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hr;

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hr.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hr.findAll();
	}

	@Override
	public Hotel getHotel(Integer id) throws HotelException {
		// TODO Auto-generated method stub
		return hr.findById(id).orElseThrow(() -> new HotelException("No Such Hotel are avilable with Given id" + id));
	}

}

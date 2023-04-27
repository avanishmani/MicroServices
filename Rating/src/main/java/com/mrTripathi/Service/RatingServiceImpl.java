package com.mrTripathi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrTripathi.Exception.RatingException;
import com.mrTripathi.Repository.RatingRepo;
import com.mrTripathi.model.Rating;
@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepo rr;

	@Override
	public Rating createRating(Rating r) {
		// TODO Auto-generated method stub
		return rr.save(r);
	}

	@Override
	public List<Rating> getRating() throws RatingException {
		List<Rating> lr=rr.findAll();
		if(lr.size()==0)throw new RatingException("No Any Rating is Avilable");
		else return lr;
	}

	@Override
	public List<Rating> getRatingByUserID(Integer UID) throws RatingException {
		List<Rating> lr = rr.findByUserID(UID);
	    if (lr.size() == 0) {
	        throw new RatingException("No Any Rating is Available with UserID" + UID);
	    } else {
	        return lr;
	    }
	}

	@Override
	public List<Rating> getRatingByHotelID(Integer HID) throws RatingException {
		List<Rating> lr = rr.findByHotelID(HID);
	    if (lr.size() == 0) {
	        throw new RatingException("No Any Rating is Available with HotelID" + HID);
	    } else {
	        return lr;
	    }
	}

}

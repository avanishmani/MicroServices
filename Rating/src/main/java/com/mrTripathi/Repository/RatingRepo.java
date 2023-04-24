package com.mrTripathi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrTripathi.model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
	List<Rating> findByUserID(Integer UID);

	List<Rating> findByHotelID(Integer HID);
}

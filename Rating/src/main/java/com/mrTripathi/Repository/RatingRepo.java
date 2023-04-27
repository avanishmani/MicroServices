package com.mrTripathi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mrTripathi.model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
	@Query("SELECT r FROM Rating r WHERE r.userID = :userID")
    List<Rating> findByUserID(@Param("userlID") Integer userID);

	 @Query("SELECT r FROM Rating r WHERE r.hotelID = :hotelID")
	    List<Rating> findByHotelID(@Param("hotelID") Integer hotelID);
}

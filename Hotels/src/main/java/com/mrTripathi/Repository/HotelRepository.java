package com.mrTripathi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrTripathi.model.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}

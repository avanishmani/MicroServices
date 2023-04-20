package com.mrTripathi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrTripathi.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}

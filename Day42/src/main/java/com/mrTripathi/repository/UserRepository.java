package com.mrTripathi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrTripathi.model.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}

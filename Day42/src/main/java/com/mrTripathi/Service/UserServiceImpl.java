package com.mrTripathi.Service;

import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mrTripathi.Exception.UserException;
import com.mrTripathi.ExternalService.HotelService;
import com.mrTripathi.ExternalService.RatingService;
import com.mrTripathi.model.Hotel;
import com.mrTripathi.model.Rating;
import com.mrTripathi.model.Users;
import com.mrTripathi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository ur;
	@Autowired
	private RestTemplate rt;
	
	@Autowired
	private HotelService hs;

	@Autowired
	private RatingService rs;

	@Override
	public Users saveUser(Users user) {
		return ur.save(user);
	}

	@Override
	public List<Users> getAllUser() {

		return ur.findAll();
	}

	@Override
	public Users getUser(Integer UserId) throws UserException {
		// TODO Auto-generated method stub
		Users u = ur.findById(UserId)
				.orElseThrow(() -> new UserException("No Such User Exist with UserID :- " + UserId));
		Rating[] ratingOfUser = rs.getRatingByUserID(UserId);
//		logger.info("{} ", ratingOfUser);
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rat -> {
//			ResponseEntity<Hotel> forEntity=rt.getForEntity("http://localhost:8082/hotel/"+rat.getHotelID(), Hotel.class);
			Hotel hotel = hs.getHotel(rat.getHotelID());
//			logger.info("",forEntity.getStatusCode());
			rat.setHotel(hotel);
			return rat;
		}).collect(Collectors.toList());

		u.setRating(ratingList);
		return u;
	}

}

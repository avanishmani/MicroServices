package com.mrTripathi.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mrTripathi.Exception.UserException;
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
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

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
		Rating[] ratingOfUser=rt.getForObject("http://localhost:8081/user/"+u.getUserId(), Rating[].class);
		logger.info("{}",ratingOfUser);
		List<Rating> ratings=Arrays.stream(ratingOfUser).toList();
		List<Rating> ratingList=ratings.stream().map(rat->{
			ResponseEntity<Hotel> forEntity=rt.getForEntity("http://localhost:8082/hotel/"+rat.getHotelID(), Hotel.class);
			Hotel hotel=forEntity.getBody();
			logger.info("",forEntity.getStatusCode());
			rat.setHotel(hotel);
			return rat;
		}).collect(Collectors.toList());
		
		u.setRating(ratings);
		return u;
	}

}

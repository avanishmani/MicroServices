package com.mrTripathi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrTripathi.Exception.UserException;
import com.mrTripathi.model.Users;
import com.mrTripathi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository ur;

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
		return ur.findById(UserId).orElseThrow(() -> new UserException("No Such User Exist with UserID :- " + UserId));
	}

}

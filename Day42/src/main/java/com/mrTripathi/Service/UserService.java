package com.mrTripathi.Service;

import java.util.List;

import com.mrTripathi.Exception.UserException;
import com.mrTripathi.model.Users;

public interface UserService {
	public Users saveUser(Users user);

	public List<Users> getAllUser();

	public Users getUser(String UserId) throws UserException;
}

package com.zil.flight_reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zil.flight_reservation_app.entity.User;
import com.zil.flight_reservation_app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	

	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveUser(User user) {
		
		
		userRepo.save(user);
	}

	@Override
	public Boolean verifyLogin(String email, String password) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password))
				return true;
		}
		return false;
	}

}

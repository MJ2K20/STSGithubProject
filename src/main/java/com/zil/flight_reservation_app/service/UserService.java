package com.zil.flight_reservation_app.service;


import com.zil.flight_reservation_app.entity.User;


public interface UserService {
	public void saveUser(User user);

	public Boolean verifyLogin(String email, String password);
}

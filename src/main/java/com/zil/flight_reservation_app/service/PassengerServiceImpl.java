package com.zil.flight_reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zil.flight_reservation_app.entity.Passenger;
import com.zil.flight_reservation_app.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public void savePassenger(Passenger passenger) {
		passengerRepo.save(passenger);
	}

}

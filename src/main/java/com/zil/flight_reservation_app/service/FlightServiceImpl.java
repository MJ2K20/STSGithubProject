package com.zil.flight_reservation_app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zil.flight_reservation_app.entity.Flight;
import com.zil.flight_reservation_app.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepo;

	@Override
	public List<Flight> searchFlights(String from, String to, Date departureDate) {
		List<Flight> flights = flightRepo.searchFlights(from,to,departureDate);
		return flights;
	}

	@Override
	public Flight findById(Long flightId) {
		Optional<Flight> findById = flightRepo.findById(flightId);	
		Flight flight = findById.get();	
		return flight;
	}

}

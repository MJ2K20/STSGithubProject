package com.zil.flight_reservation_app.service;

import java.util.Date;
import java.util.List;


import com.zil.flight_reservation_app.entity.Flight;

public interface FlightService {

	List<Flight> searchFlights(String from, String to, Date departureDate);

	Flight findById(Long flightId);

}

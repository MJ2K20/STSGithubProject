package com.zil.flight_reservation_app.service;

import com.zil.flight_reservation_app.dto.ReservationRequest;

import com.zil.flight_reservation_app.dto.ReservationUpdateRequest;
import com.zil.flight_reservation_app.entity.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);

	Reservation findById(Long id);

	Reservation saveRestUpdate(ReservationUpdateRequest rest);
	
}

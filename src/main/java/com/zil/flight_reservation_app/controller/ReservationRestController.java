package com.zil.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.zil.flight_reservation_app.dto.ReservationUpdateRequest;
import com.zil.flight_reservation_app.entity.Reservation;
import com.zil.flight_reservation_app.service.ReservationService;

@RestController
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/reservation/{id}")
	public Reservation getReservationById(@PathVariable("id") Long id) {
		Reservation reservation = reservationService.findById(id);
		return reservation;
	}
	
	@PostMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest rest) {
		Reservation reservation = reservationService.saveRestUpdate(rest);
		return reservation;
	}
}

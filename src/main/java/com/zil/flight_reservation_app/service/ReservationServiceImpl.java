package com.zil.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zil.flight_reservation_app.dto.ReservationRequest;

import com.zil.flight_reservation_app.dto.ReservationUpdateRequest;
import com.zil.flight_reservation_app.entity.Flight;
import com.zil.flight_reservation_app.entity.Passenger;
import com.zil.flight_reservation_app.entity.Reservation;
import com.zil.flight_reservation_app.repository.ReservationRepository;
import com.zil.flight_reservation_app.util.EmailUtil;
import com.zil.flight_reservation_app.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Flight flight = flightService.findById(request.getFlightId());
		
		Passenger passenger = new Passenger();
		
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerService.savePassenger(passenger);
		
		
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setNumberOfBags(0);
		reservation.setPassenger(passenger);
		reservationRepo.save(reservation);
		
		String filePath = "C:\\Users\\manji\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\flight_reservation_app\\tickets\\ticket" + reservation.getId() + ".pdf";
		
		pdfGenerator.generatePDF(filePath, reservation);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return reservation;
	}

	@Override
	public Reservation findById(Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}

	@Override
	public Reservation saveRestUpdate(ReservationUpdateRequest rest) {
		Optional<Reservation> findById = reservationRepo.findById(rest.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(rest.isCheckedIn());
		reservation.setNumberOfBags(rest.getNumberOfBags());
		reservationRepo.save(reservation);
		return reservation;
	}


}

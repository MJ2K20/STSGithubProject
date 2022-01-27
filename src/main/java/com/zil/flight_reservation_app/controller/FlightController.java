package com.zil.flight_reservation_app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zil.flight_reservation_app.entity.Flight;
import com.zil.flight_reservation_app.service.FlightService;

@Controller
public class FlightController {

	@Autowired
	private FlightService flightService;

	@RequestMapping("/showFlights")
	public String showFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap modelMap) {
		
		List<Flight> flights = flightService.searchFlights(from,to,departureDate);
		
		modelMap.addAttribute("flights", flights);
		
		return "flight/showFlights";
	}
	
	@RequestMapping("/makeReservation")
	public String makeReservation(@RequestParam("flightId") Long flightId, ModelMap  modelMap) 
	{
		Flight flightDetails = flightService.findById(flightId);
		modelMap.addAttribute("flight", flightDetails);
		return "reservation/makeReservation";
	}

}

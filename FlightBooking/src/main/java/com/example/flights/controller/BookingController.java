package com.example.flights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.flights.model.FlightBooking;
import com.example.flights.service.BookingService;

public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/booking")
	public  FlightBooking booking(@RequestBody FlightBooking flightBooking) {
		return bookingService.bookingTicket(flightBooking);
	}
	

}

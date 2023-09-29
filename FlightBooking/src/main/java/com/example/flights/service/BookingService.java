package com.example.flights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.flights.model.FlightBooking;
import com.example.flights.model.Flights;
import com.example.flights.repository.BookingRepository;

public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	RestTemplate restTemplate;
	
	
	
	public FlightBooking bookingTicket(FlightBooking flightBooking) {
		
		Flights flights=restTemplate.getForObject("http://localhost:8080/byFlightNumber/"+flightBooking.getFlights().getFlightNumber(), Flights.class);
		
	if(flights.getAvailableSeats()>=flightBooking.getNumberOfSeats()) {
		 bookingRepository.save(flightBooking);
		restTemplate.getForObject("http://localhost:8080/bookedTicket/"+flightBooking.getFlights().getFlightNumber()+"/"+flightBooking.getNumberOfSeats(), Flights.class);
		return flightBooking;
	}
	else {
		return new FlightBooking(null, "avaliable seats are "+flights.getAvailableSeats(), null, null, 0, flights, null);
	}
	
	

	
	}
	

}

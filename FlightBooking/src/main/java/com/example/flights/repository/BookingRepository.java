package com.example.flights.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.flights.model.FlightBooking;
import com.example.flights.model.Flights;

public interface BookingRepository extends MongoRepository<FlightBooking, String> {
	
	public Flights findByFlightNumber(String flightNumber);
	

}

package com.example.flights.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.flights.model.Flights;
@Repository
public interface FlightRepository extends MongoRepository<Flights, String> {
	
	public List<Flights> findAll();
	
	
	public Flights findByFlightNumber(String flightNumber);
	
//	public Flights  findByAvailableSeats(Integer availableSeats);
	
	public List<Flights> findByOriginAndDestination(String origin,String destination);	
	
	public List<Flights> findByDateOfFlight(String dateOfFlight);

	
}

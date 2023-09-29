package com.example.flights.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flights.model.Flights;
import com.example.flights.repository.FlightRepository;
@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	
	public List<Flights> getAllFlights(){
		return flightRepository.findAll();	
}
  
  public Flights getByFlightNumber(String finghtNumber) {
	  return flightRepository.findByFlightNumber(finghtNumber);
  }
  
  public List<Flights> getFlightByOriginAndDestination(String origin,String destination){
	  return flightRepository.findByOriginAndDestination(origin, destination);
	  
  }
  
  public List<Flights> getFlightsBasedOnSelectedDate(String dateFlight){
	  return flightRepository.findByDateOfFlight(dateFlight);
  }
  
  public Flights addFlights(Flights flights) {
	  return flightRepository.save(flights);
  }
  
  public boolean bookTicket(String flightNumber) {
	  
	  Flights flights=flightRepository.findByFlightNumber(flightNumber);
	  
	  if(flights.getAvailableSeats()==0) {
		  
		  return false;
		  
	  }
	  else {
		
		  flightRepository.save(flights);
		  return true;
 
		  
	  }
	  
	  
  }
  
  public Flights ticketBooked(String flightNumber ,int noOfSeats) {
	  
	  Flights flights=flightRepository.findByFlightNumber(flightNumber);
	  flights.setAvailableSeats(flights.getAvailableSeats()-noOfSeats);
	   return flightRepository.save(flights);
	  
  }
  
  public Flights updateFlight(Flights flights) {
	  Flights flights2=flightRepository.findByFlightNumber(flights.getFlightNumber()) ;
	  flights2.setOrigin(flights.getOrigin());
	  flights2.setDestination(flights.getDestination());
	  flights2.setDepartureTime(flights.getDepartureTime());
	  flights2.setArrivalTime(flights.getArrivalTime());
	  flights2.setAvailableSeats(flights.getAvailableSeats());
	  return flightRepository.save(flights2);
	  
  }
  public String deleteFlight(String id) {
	  Flights flights=flightRepository.findByFlightNumber(id);
	  flightRepository.delete(flights);
	  return "flight delete successfully";
  }
}
package com.example.flights.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flights.model.Flights;
import com.example.flights.service.FlightService;
@RestController
public class FlightController {
	
	

	    @Autowired
	    private FlightService flightService;

	    @GetMapping("/getAllFlights")
	    public List<Flights> getAllFlights() {
	        return flightService.getAllFlights();
	    }

	    @GetMapping("/byFlightNumber/{flightNumber}")
	    public Flights getByFlightNumber(@PathVariable("flightNumber") String flightNumber) {
	        return flightService.getByFlightNumber(flightNumber);
	    }

	    @GetMapping("/byOriginAndDestination/{origin}/{destination}")
	    public List<Flights> getFlightByOriginAndDestination(@PathVariable("origin") String origin,
	            @PathVariable("destination") String destination) {
	        return flightService.getFlightByOriginAndDestination(origin, destination);
	    }
	    @GetMapping("/byGetFlights/{yyyy-mm-dd}")
	    public List<Flights> getFlights(@PathVariable("yyyy-mm-dd") String flightDate){
	    	return flightService.getFlightsBasedOnSelectedDate(flightDate);
	    }
	    @PostMapping("/addFlight")
	    public Flights addFlight(@RequestBody Flights flight) {
	        return flightService.addFlights(flight);
	    }
	    @GetMapping("/checkTickets/{id}")
	    public boolean checkTickets(@PathVariable("id") String flightNumber) {
	    	return flightService.bookTicket(flightNumber);
	    }
	    @PutMapping("/bookedTicket/{fNo}/{seats}")
	    public Flights bookedTicket(@PathVariable("fNo") String flightNumber,@PathVariable("seats") int noOfSeats) {
	    	return flightService.ticketBooked(flightNumber, noOfSeats);
	    }

	    @PutMapping("/updateFlight")
	    public Flights updateFlight(@RequestBody Flights flight) {
	        return flightService.updateFlight(flight);
	    }

	    @DeleteMapping("/delete/{flightNumber}")
	    public String deleteFlight(@PathVariable String flightNumber) {
	        return flightService.deleteFlight(flightNumber);
	    }
	}

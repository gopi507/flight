package com.example.flights.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "flights")
public class Flights {
	
	@Id
    public String flightNumber;
    public  String origin; 
    public  String destination; 
    public String dateOfFlight;
    public String departureTime;
    public  String arrivalTime;
    public  Integer availableSeats;

}

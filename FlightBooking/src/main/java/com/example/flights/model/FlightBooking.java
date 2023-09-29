package com.example.flights.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightBooking {
	@Id
	 public Long bookingId;
     public  String passengerName;
     public  String email;
     public  String contactNumber;
     public  int numberOfSeats;
     public Flights flights;
     public String bookingDate;
      
      

	
	

}

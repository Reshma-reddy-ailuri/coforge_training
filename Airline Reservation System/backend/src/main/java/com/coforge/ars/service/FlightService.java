package com.coforge.ars.service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

import com.coforge.ars.model.Flight;



public interface FlightService {
	boolean saveFlight(Flight flight);
	boolean updateFlight(Integer flightId,Flight flight);
	boolean deleteFlightById(Integer flightId);
	Optional<Flight> findByFlightId(Integer flightId);
	List<Flight> findAllFlights();
	
	//to update flight status
	boolean updateFlightStatus(Integer flightId,String flightStatus);
	
	List<Flight> searchFlights(Integer departureAirportId,
			Integer arrivalAirportId,
			LocalDateTime journeyDate);
}

package com.coforge.ars.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ars.model.Flight;
import com.coforge.ars.service.FlightService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class FlightController {

	private FlightService service;
	private Environment environment;
	
	@Autowired
	public FlightController(FlightService service,Environment environment) {
		this.service = service;
		this.environment = environment;
	}
	
	@PostMapping("/flights")
	public ResponseEntity<String> saveFlight(@Valid @RequestBody Flight flight) {
		service.saveFlight(flight);
		return new ResponseEntity<>(
				environment.getProperty("flight.save.success"),HttpStatus.CREATED);
	}
	
	@PutMapping("/flights/{flightId}")
	public ResponseEntity<String> updateFlight(@PathVariable Integer flightId, @Valid @RequestBody Flight flight){
		service.updateFlight(flightId, flight);
		return new ResponseEntity<>(
				environment.getProperty("flight.update.success"),HttpStatus.OK);
	}
	
	@DeleteMapping("/flights/{flightId}")
	public ResponseEntity<String> deleteFlight(@PathVariable Integer flightId) {
		service.deleteFlightById(flightId);
		return new ResponseEntity<> (
				environment.getProperty("flight.delete.success"),HttpStatus.OK);
	}
	
	@GetMapping("/flights/{flightId}")
	public ResponseEntity<Flight> findByFlightId(@PathVariable Integer flightId) {
		Optional<Flight> flight = service.findByFlightId(flightId);
		
		return new ResponseEntity<>(
				flight.get(),HttpStatus.OK);
	}
	
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> findAllFlights() {
		return new ResponseEntity<> (
				service.findAllFlights(),HttpStatus.OK);
	}
	
	//TO UPDATE FLIGHT STATUS
	@PutMapping("/flights/{flightId}/status/{flightStatus}")
	public ResponseEntity<String> updateFlightStatus(
	        @PathVariable Integer flightId,
	        @PathVariable String flightStatus) {

	    service.updateFlightStatus(flightId, flightStatus);

	    return new ResponseEntity<>(
	            environment.getProperty("flight.update.success"),
	            HttpStatus.OK);
	}
	
	@GetMapping("/flights/search")
	public ResponseEntity<List<Flight>> searchFlights(

			@RequestParam Integer departureAirportId,

			@RequestParam Integer arrivalAirportId,

			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
			LocalDateTime journeyDate) {

		return new ResponseEntity<>(

				service.searchFlights(
						departureAirportId,
						arrivalAirportId,
						journeyDate),

				HttpStatus.OK);
	}

}

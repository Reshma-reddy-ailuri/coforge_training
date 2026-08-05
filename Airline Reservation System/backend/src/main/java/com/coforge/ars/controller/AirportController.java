package com.coforge.ars.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ars.model.Airport;
import com.coforge.ars.service.AirportService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class AirportController {

	private AirportService service;
	private Environment environment;
	
	@Autowired
	public AirportController(AirportService service,Environment environment) {
		this.service = service;
		this.environment = environment;
	}
	
	@PostMapping("/airports")
	public ResponseEntity<String> saveAirport(@Valid @RequestBody Airport airport) {
		service.saveAirport(airport);
		return new ResponseEntity<>(
				environment.getProperty("airport.save.success"),HttpStatus.CREATED);
	}
	
	@PutMapping("/airports/{airportId}")
	public ResponseEntity<String> updateAirport(@PathVariable Integer airportId, @Valid @RequestBody Airport airport){
		service.updateAirport(airportId, airport);
		return new ResponseEntity<>(
				environment.getProperty("airport.update.success"),HttpStatus.OK);
	}
	
	@DeleteMapping("/airports/{airportId}")
	public ResponseEntity<String> deleteAirport(@PathVariable Integer airportId) {
		service.deleteAirportById(airportId);
		return new ResponseEntity<> (
				environment.getProperty("airport.delete.success"),HttpStatus.OK);
	}
	
	@GetMapping("/airports/{airportId}")
	public ResponseEntity<Airport> findByAirportId(@PathVariable Integer airportId) {
		Optional<Airport> airport = service.findByAirportId(airportId);
		
		return new ResponseEntity<>(
				airport.get(),HttpStatus.OK);
	}
	
	@GetMapping("/airports")
	public ResponseEntity<List<Airport>> findAllAirports() {
		return new ResponseEntity<> (
				service.findAllAirports(),HttpStatus.OK);
	}

}

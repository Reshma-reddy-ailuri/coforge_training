package com.coforge.ars.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coforge.ars.model.Passenger;
import com.coforge.ars.service.PassengerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class PassengerController {

	private PassengerService service;
	private Environment environment;

	@Autowired
	public PassengerController(PassengerService service, Environment environment) {
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/passengers")
	public ResponseEntity<String> savePassenger(@Valid @RequestBody Passenger passenger) {

		service.savePassenger(passenger);

		return new ResponseEntity<>(
				environment.getProperty("passenger.save.success"),
				HttpStatus.CREATED);
	}

	@PutMapping("/passengers/{passengerId}")
	public ResponseEntity<String> updatePassenger(@PathVariable Integer passengerId,
			@Valid @RequestBody Passenger passenger) {

		service.updatePassenger(passengerId, passenger);

		return new ResponseEntity<>(
				environment.getProperty("passenger.update.success"),
				HttpStatus.OK);
	}

	@DeleteMapping("/passengers/{passengerId}")
	public ResponseEntity<String> deletePassenger(@PathVariable Integer passengerId) {

		service.deletePassengerById(passengerId);

		return new ResponseEntity<>(
				environment.getProperty("passenger.delete.success"),
				HttpStatus.OK);
	}

	@GetMapping("/passengers/{passengerId}")
	public ResponseEntity<Passenger> findByPassengerId(@PathVariable Integer passengerId) {

		Optional<Passenger> passenger = service.findByPassengerId(passengerId);

		return new ResponseEntity<>(
				passenger.get(),
				HttpStatus.OK);
	}

	@GetMapping("/passengers")
	public ResponseEntity<List<Passenger>> findAllPassengers() {

		return new ResponseEntity<>(
				service.findAllPassengers(),
				HttpStatus.OK);
	}

}
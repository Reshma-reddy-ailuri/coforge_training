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

import com.coforge.ars.model.Airplane;
import com.coforge.ars.service.AirplaneService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class AirplaneController {

	private AirplaneService service;
	private Environment environment;
	
	@Autowired
	public AirplaneController(AirplaneService service,Environment environment) {
		this.service = service;
		this.environment = environment;
	}
	
	@PostMapping("/airplanes")
	public ResponseEntity<String> saveAirplane(@Valid @RequestBody Airplane airplane) {
		service.saveAirplane(airplane);
		return new ResponseEntity<>(
				environment.getProperty("airplane.save.success"),HttpStatus.CREATED);
	}
	
	@PutMapping("/airplanes/{airplaneId}")
	public ResponseEntity<String> updateAirplane(@PathVariable Integer airplaneId, @Valid @RequestBody Airplane airplane){
		service.updateAirplane(airplaneId, airplane);
		return new ResponseEntity<>(
				environment.getProperty("airplane.update.success"),HttpStatus.OK);
	}
	
	@DeleteMapping("/airplanes/{airplaneId}")
	public ResponseEntity<String> deleteAirplane(@PathVariable Integer airplaneId) {
		service.deleteAirplaneById(airplaneId);
		return new ResponseEntity<> (
				environment.getProperty("airplane.delete.success"),HttpStatus.OK);
	}
	
	@GetMapping("/airplanes/{airplaneId}")
	public ResponseEntity<Airplane> findByAirplaneId(@PathVariable Integer airplaneId) {
		Optional<Airplane> airplane = service.findByAirplaneId(airplaneId);
		
		return new ResponseEntity<>(
				airplane.get(),HttpStatus.OK);
	}
	
	@GetMapping("/airplanes")
	public ResponseEntity<List<Airplane>> findAllAirplanes() {
		return new ResponseEntity<> (
				service.findAllAirplanes(),HttpStatus.OK);
	}

}

package com.coforge.ars.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coforge.ars.model.WaitingList;
import com.coforge.ars.service.WaitingListService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class WaitingListController {

	private WaitingListService service;
	private Environment environment;

	@Autowired
	public WaitingListController(WaitingListService service, Environment environment) {
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/waitinglists")
	public ResponseEntity<String> saveWaitingList(@Valid @RequestBody WaitingList waitingList) {

		service.saveWaitingList(waitingList);

		return new ResponseEntity<>(
				environment.getProperty("waiting.save.success"),
				HttpStatus.CREATED);
	}

	@PutMapping("/waitinglists/{waitingId}")
	public ResponseEntity<String> updateWaitingList(@PathVariable Integer waitingId,
			@Valid @RequestBody WaitingList waitingList) {

		service.updateWaitingList(waitingId, waitingList);

		return new ResponseEntity<>(
				environment.getProperty("waiting.update.success"),
				HttpStatus.OK);
	}

	@DeleteMapping("/waitinglists/{waitingId}")
	public ResponseEntity<String> deleteWaitingList(@PathVariable Integer waitingId) {

		service.deleteWaitingListById(waitingId);

		return new ResponseEntity<>(
				environment.getProperty("waiting.delete.success"),
				HttpStatus.OK);
	}

	@GetMapping("/waitinglists/{waitingId}")
	public ResponseEntity<WaitingList> findByWaitingId(@PathVariable Integer waitingId) {

		Optional<WaitingList> waitingList = service.findByWaitingId(waitingId);

		return new ResponseEntity<>(
				waitingList.get(),
				HttpStatus.OK);
	}

	@GetMapping("/waitinglists")
	public ResponseEntity<List<WaitingList>> findAllWaitingLists() {

		return new ResponseEntity<>(
				service.findAllWaitingLists(),
				HttpStatus.OK);
	}

}
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

import com.coforge.ars.model.User;
import com.coforge.ars.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/users")
public class UserController {

	private UserService service;
	private Environment environment;

	@Autowired
	public UserController(UserService service, Environment environment) {
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@Valid @RequestBody User user) {

		service.saveUser(user);

		return new ResponseEntity<>(
				environment.getProperty("user.save.success"),
				HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable Integer userId,
			@Valid @RequestBody User user) {

		service.updateUser(userId, user);

		return new ResponseEntity<>(
				environment.getProperty("user.update.success"),
				HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {

		service.deleteUserById(userId);

		return new ResponseEntity<>(
				environment.getProperty("user.delete.success"),
				HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> findByUserId(@PathVariable Integer userId) {

		Optional<User> user = service.findByUserId(userId);

		return new ResponseEntity<>(
				user.get(),
				HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAllUsers() {

		return new ResponseEntity<>(
				service.findAllUsers(),
				HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {

		Optional<User> loginUser = service.login(
				user.getEmail(),
				user.getPassword());

		return new ResponseEntity<>(
				loginUser.get(),
				HttpStatus.OK);
	}
}
package com.coforge.ars.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private Environment environment;

	@Autowired
	public GlobalExceptionHandler(Environment environment) {
		this.environment = environment;
	}


	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e) {
		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}



	@ExceptionHandler(AirportNotFoundException.class)
	public ResponseEntity<?> handleAirportNotFoundException(AirportNotFoundException e) {
		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(AirplaneNotFoundException.class)
	public ResponseEntity<?> handleAirplaneNotFoundException(AirplaneNotFoundException e) {
		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<?> handleFlightNotFoundException(FlightNotFoundException e) {
		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(WalletNotFoundException.class)
	public ResponseEntity<?> handleWalletNotFoundException(WalletNotFoundException e) {

		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(WalletAlreadyExistsException.class)
	public ResponseEntity<?> handleWalletAlreadyExistsException(WalletAlreadyExistsException e) {

		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<?> handleBookingNotFoundException(BookingNotFoundException e) {

		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PassengerNotFoundException.class)
	public ResponseEntity<?> handlePassengerNotFoundException(PassengerNotFoundException e) {

		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WaitingListNotFoundException.class)
	public ResponseEntity<?> handleWaitingListNotFoundException(WaitingListNotFoundException e) {

		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<?> handleInsufficientBalanceException(
			InsufficientBalanceException e) {

		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

		return new ResponseEntity<>(
				environment.getProperty("invalid.details"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {

		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

}
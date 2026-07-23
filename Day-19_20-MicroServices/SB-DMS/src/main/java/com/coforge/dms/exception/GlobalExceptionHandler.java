package com.coforge.dms.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //to handles global Exception
public class GlobalExceptionHandler {
	private Environment environment;
	
	@Autowired
	public GlobalExceptionHandler(Environment environment) {
		super();
		this.environment = environment;
	}

	@ExceptionHandler(DepartmentNotFoundException.class) //to handle specific exception
	public ResponseEntity<?> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
}
	
	@ExceptionHandler(MethodArgumentNotValidException.class) //to handle specific exception
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		return new ResponseEntity<>(environment.getProperty("dms.invalid.department-details"),HttpStatus.BAD_REQUEST);

}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		return new ResponseEntity<>(environment.getProperty("dms.db.failed"),HttpStatus.BAD_REQUEST);

}
}	

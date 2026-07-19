package com.coforge.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/ems")
public class EmployeeController {

	private EmployeeService service;
	private Environment environment;

	@Autowired
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	// CREATE
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.saveEmployee(employee);

			if (status) {
				responseEntity = new ResponseEntity<>(
						environment.getProperty("ems.save.success"),
						HttpStatus.CREATED);
			}

		} catch (InvalidEmployeeObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// UPDATE BY ID
	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> updateEmployee(@PathVariable("eid") int eid,
			@RequestBody Employee employee) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.updateEmployee(eid, employee);

			if (status) {
				responseEntity = new ResponseEntity<>(
						environment.getProperty("ems.update.success"),
						HttpStatus.OK);
			}

		} catch (InvalidEmployeeObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// DELETE BY ID
	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> deleteByEid(@PathVariable("eid") int eid) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.deleteByEid(eid);

			if (status) {
				responseEntity = new ResponseEntity<>(
						environment.getProperty("ems.delete.success"),
						HttpStatus.OK);
			}

		} catch (InvalidEmployeeObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (EmployeeNotFoundException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// FIND BY ID
	@GetMapping("/employees/{eid}")
	public ResponseEntity<?> findByEid(@PathVariable("eid") int eid) {

		ResponseEntity<?> responseEntity = null;

		try {

			Optional<Employee> employee = service.findByEid(eid);

			if (employee.isPresent()) {

				responseEntity = new ResponseEntity<>(
						employee.get(),
						HttpStatus.OK);
			}

		} catch (InvalidEmployeeObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (EmployeeNotFoundException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// FIND ALL
	@GetMapping("/employees")
	public ResponseEntity<?> findAllEmployees() {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Employee> employees = service.findAllEmployee();

			responseEntity = new ResponseEntity<>(
					employees,
					HttpStatus.OK);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// FIND BY ENAME
	@GetMapping("/employees/ename/{ename}")
	public ResponseEntity<?> findByEname(@PathVariable("ename") String ename) {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Employee> employee = service.findByEname(ename);

			responseEntity = new ResponseEntity<>(
					employee,
					HttpStatus.OK);

		} catch (InvalidEmployeeObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// DELETE BY ENAME
	@DeleteMapping("/employees/ename/{ename}")
	public ResponseEntity<?> deleteByEname(@PathVariable("ename") String ename) {

		ResponseEntity<?> responseEntity = null;

		try {

			boolean status = service.deleteByEname(ename);

			if (status) {
				responseEntity = new ResponseEntity<>(
						environment.getProperty("ems.delete.success"),
						HttpStatus.OK);
			}

		} catch (InvalidEmployeeObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (EmployeeNotFoundException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// GET ALL EMPLOYEE IDS
	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Integer> eids = service.getEidsList();

			responseEntity = new ResponseEntity<>(
					eids,
					HttpStatus.OK);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
	
	@GetMapping("/employees/info")
	public ResponseEntity<?> getInfo() {

		ResponseEntity<?> responseEntity = null;

		try {

			String info = service.getInfo();

			responseEntity = new ResponseEntity<>(info,HttpStatus.OK);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

}
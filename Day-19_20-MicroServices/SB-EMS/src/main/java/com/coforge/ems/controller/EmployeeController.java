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

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.dto.EmployeeDTO;
import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

//@RestController is used to create RESTful web services that return data directly 
//in the HTTP response body. @RestController 
//is a combination of @Controller and @ResponseBody.

@RestController
@RequestMapping("/api/v1/ems") // version of ems
public class EmployeeController {
	
	// @Autowired // field injection
	private EmployeeService service;
	private Environment environment;

	@Autowired // construction injection
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee employee) { 
		ResponseEntity<String> responseEntity = null;

		boolean status = service.saveEmployee(employee);
		if (status)
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.success"), HttpStatus.CREATED);

		return responseEntity;
	}

	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> updateEmployee(@Valid @NotNull @PathVariable("eid") int eid, @Valid @RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.updateEmployee(eid, employee);
		if (status)
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.update.success"), HttpStatus.CREATED);
		return responseEntity;
	}

	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> deleteByEid(@Valid @PathVariable("eid") int eid) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.deleteByEid(eid);
		if (status)
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/employees/{eid}")
	public ResponseEntity<?> findByEid(@PathVariable("eid") int eid) {
		ResponseEntity<?> responseEntity = null;

		Optional<Employee> employee = service.findByEid(eid);
		if (employee.isPresent())
			responseEntity = new ResponseEntity<>(employee.get(), HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/employees")
	public ResponseEntity<?> findAllEmployees() {
		ResponseEntity<?> responseEntity = null;
		List<Employee> employees = service.findAllEmployees();
		responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/employees/ename/{ename}")
	public ResponseEntity<?> findByEname(@PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;

		List<Employee> employees = service.findByEname(ename);
		responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);

		return responseEntity;
	}

	@DeleteMapping("/employees/ename/{ename}")
	public ResponseEntity<?> deleteByEname(@PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;
		boolean status = service.deleteByEname(ename);
		responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {
		ResponseEntity<?> responseEntity = null;

		List<Integer> eids = service.getEidsList();
		responseEntity = new ResponseEntity<>(eids, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/employees/info")
	public ResponseEntity<?> getInfo() {
		ResponseEntity<?> responseEntity = null;

		String info = service.getInfo();
		responseEntity = new ResponseEntity<>(info, HttpStatus.OK);
		return responseEntity;
	}
	
	//REST end points for feign client department
	
	@GetMapping("/employees/departments/{dno}")
	public ResponseEntity<?> findDepartmentById(@PathVariable int dno) {
		ResponseEntity<?> responseEntity = null;
		DepartmentDTO department = service.findDepartmentById(dno);
		if(department!=null) 
			responseEntity = new ResponseEntity<>(department, HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<>("FAILED:department not found", HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	@GetMapping("/employees/departments")
	public ResponseEntity<List<DepartmentDTO>> findAllDepartments() {
		ResponseEntity<List<DepartmentDTO>> responseEntity = null;
		List<DepartmentDTO> departments = service.findAllDepartments();
			responseEntity = new ResponseEntity<>(departments, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/employees/{eid}/departments")
	public ResponseEntity<EmployeeDTO> findEmployeeDetails(@PathVariable("eid") int eid) {
		ResponseEntity<EmployeeDTO> responseEntity = null;
		EmployeeDTO employeeDto = new EmployeeDTO();
		
		Employee employee = service.findByEid(eid).get();
		DepartmentDTO department = service.findDepartmentById(employee.getDno());
		
		employeeDto.setEmployee(employee);
		employeeDto.setDepartment(department);
		responseEntity = new ResponseEntity<>(employeeDto, HttpStatus.OK);

		return responseEntity;
	}
}
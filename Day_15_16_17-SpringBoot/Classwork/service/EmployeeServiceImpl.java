package com.coforge.ems.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepo repo;
	private Environment environment;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}

	
	@Override
	public boolean saveEmployee(Employee employee)  {
			repo.save(employee);
			return true;
		
}

	@Override
	public boolean updateEmployee(int eid, Employee employee) {
			if(! repo.existsById(eid)) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notfound"));
				}
				// save method works for both insert and update in springboot whereas in hibernate we have save,update and save or update.	
			repo.save(employee);
			return true;
	}

	@Override
	public boolean deleteByEid(int eid) throws EmployeeNotFoundException {
			if(! repo.existsById(eid)) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notfound"));
			}
			repo.deleteById(eid);
			return true;
	}
	
	@Override
	public Optional<Employee> findByEid(int eid) throws EmployeeNotFoundException {
			if(! repo.existsById(eid)) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notfound"));
			}
			return repo.findById(eid);
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employees = (List<Employee> ) repo.findAll();
		return employees;
	}

	@Override
	public List<Employee> findByEname(String ename) throws EmployeeNotFoundException {
			List<Employee > employee = repo.findByEname(ename);
			if(employee.isEmpty()) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notfound"));
			}
			return employee;
	}

	@Override
	@Transactional
	public boolean deleteByEname(String ename)throws EmployeeNotFoundException {
	        int n = repo.deleteByEname(ename);
	        if(n==0) {
	        	throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notfound"));
	        }
	        return true;
	}

	@Override
	public List<Integer> getEidsList() {
	    List<Integer> eids = repo.getEids();
	    return eids;
	}

	@Override
	public String getInfo() {
		String info = repo.getInfo();
		return info;
	}
	
}

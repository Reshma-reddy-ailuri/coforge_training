package com.coforge.ems.service;

import java.sql.SQLException;
import java.util.List;

import com.coforge.ems.dao.EmployeeDAO;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;

public class EmployeeService {

	private EmployeeDAO dao = new EmployeeDAO();

	public int createEmployee(Employee employee)
			throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;
		if (employee != null && employee.getEname() != null && employee.getEid() > 0 && employee.getEsalary() > 0
				&& employee.getDno() > 0) {
			n = dao.createEmployee(employee);
		} else {
			throw new InvalidEmployeeObjectException();
		}
		return n;
	}

	public int updateEmployee(Employee employee)
			throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;

		if (employee != null && employee.getEname() != null && employee.getEid() > 0 && employee.getEsalary() > 0
				&& employee.getDno() > 0) {
			n = dao.updateEmployee(employee);
		} else {
			throw new InvalidEmployeeObjectException();
		}
		return n;
	}

	public int deleteEmployee(int eid) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;

		if (eid > 0) {
			n = dao.deleteEmployee(eid);
		} else {
			throw new InvalidEmployeeObjectException();
		}
		return n;
	}

	public List<Employee> findAllEmployee() throws ClassNotFoundException, SQLException {
		return dao.finalAllEmployee();
	}

	public Employee findEmployee(int eid) throws SQLException, ClassNotFoundException, InvalidEmployeeObjectException {

		if (eid > 0) {
			return dao.findEmployee(eid);
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

}

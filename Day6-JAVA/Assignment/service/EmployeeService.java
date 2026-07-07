package com.coforge.ems.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.coforge.ems.dao.EmployeeDAO;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();

    // CREATE method
    public int createEmployee(Employee employee)
            throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

        int n = 0;

        if (employee != null &&
            employee.getEid() > 0 &&
            employee.getEname() != null &&
            !employee.getEname().trim().isEmpty() &&
            employee.getEsalary() > 0) {

            n = dao.createEmployee(employee);

        } else {

            throw new InvalidEmployeeObjectException();

        }

        return n;
    }

    // UPDATE method
    public int updateEmployee(Employee employee)
            throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

        int n = 0;

        if (employee != null &&
            employee.getEid() > 0 &&
            employee.getEname() != null &&
            !employee.getEname().trim().isEmpty() &&
            employee.getEsalary() > 0) {

            n = dao.updateEmployee(employee);

        } else {

            throw new InvalidEmployeeObjectException();

        }

        return n;
    }

    // DELETE method
    public int deleteEmployee(int eid)
            throws ClassNotFoundException, SQLException {

        int n = 0;

        if (eid > 0) {
            n = dao.deleteEmployee(eid);
        }

        return n;
    }

    // FIND BY EMPLOYEE ID
    public Optional<Employee> findEmployee(int eid)
            throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

        if (eid > 0) {

            return dao.findEmployee(eid);

        } else {

            throw new InvalidEmployeeObjectException();

        }
    }

    // FIND ALL EMPLOYEES
    public List<Employee> findAllEmployee()
            throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

        return dao.findAllEmployee();
    }
}
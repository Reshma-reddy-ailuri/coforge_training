package com.coforge.ems.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

public class EmployeeController {

    private EmployeeService service = new EmployeeService();

    // CREATE
    public String createEmployee(Employee employee) {

        String result = "";

        try {

            int n = service.createEmployee(employee);

            if (n == 1)
                result = ApplicationProperties.insertSuccess;
            else
                result = "FAILED : Employee Record Not Inserted";

        } catch (ClassNotFoundException e) {

            result = ApplicationProperties.dbFailed;

        } catch (SQLException e) {

            result = ApplicationProperties.dbFailed;

        } catch (InvalidEmployeeObjectException e) {

            result = e.toString();

        }

        return result;
    }

    // UPDATE
    public String updateEmployee(Employee employee) {

        String result = "";

        try {

            int n = service.updateEmployee(employee);

            if (n == 1)
                result = ApplicationProperties.updateSuccess;
            else
                result = "FAILED : Employee Record Not Updated";

        } catch (ClassNotFoundException e) {

            result = ApplicationProperties.dbFailed;

        } catch (SQLException e) {

            result = ApplicationProperties.dbFailed;

        } catch (InvalidEmployeeObjectException e) {

            result = e.toString();

        }

        return result;
    }

    // DELETE
    public String deleteEmployee(int eid) {

        String result = "";

        try {

            int n = service.deleteEmployee(eid);

            if (n == 1)
                result = ApplicationProperties.deleteSuccess;
            else
                result = "FAILED : Employee Record Not Deleted";

        } catch (ClassNotFoundException e) {

            result = ApplicationProperties.dbFailed;

        } catch (SQLException e) {

            result = ApplicationProperties.dbFailed;

        }

        return result;
    }

    // FIND BY EMPLOYEE ID
    public String findEmployee(int empId) {

        String result = "";

        try {

            Optional<Employee> employee = service.findEmployee(empId);

            if (employee != null)
                result = employee.toString();
            else
                result = "FAILED : Employee Record Not Found";

        } catch (ClassNotFoundException e) {

            result = ApplicationProperties.dbFailed;

        } catch (SQLException e) {

            result = ApplicationProperties.dbFailed;

        } catch (InvalidEmployeeObjectException e) {

            result = e.toString();

        }

        return result;
    }

    // FIND ALL EMPLOYEES
    public String findAllEmployee() {

        String result = "";

        try {

            result = service.findAllEmployee().toString();

        } catch (ClassNotFoundException e) {

            result = ApplicationProperties.dbFailed;

        } catch (SQLException e) {

            result = ApplicationProperties.dbFailed;

        } catch (InvalidEmployeeObjectException e) {

            result = e.toString();

        }

        return result;
    }

}
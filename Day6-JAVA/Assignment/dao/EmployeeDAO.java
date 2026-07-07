package com.coforge.ems.dao;

// All database related imports should be only inside DAO and DBUtil layers only
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;
import com.coforge.ems.util.DBUtil;

// DAO interacts with the database
public class EmployeeDAO {

    // CREATE
    public int createEmployee(Employee employee)
            throws ClassNotFoundException, SQLException {

        int n = 0;

        Connection connection = DBUtil.getDBConnection();

        PreparedStatement statement = connection.prepareStatement(ApplicationProperties.insertsql);

        statement.setInt(1, employee.getEid());
        statement.setString(2, employee.getEname());
        statement.setInt(3, employee.getEsalary());
        statement.setInt(4, employee.getDno());

        n = statement.executeUpdate();

        return n;
    }

    // UPDATE
    public int updateEmployee(Employee employee)
            throws ClassNotFoundException, SQLException {

        int n = 0;

        Connection connection = DBUtil.getDBConnection();

        PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updatesql);

        statement.setString(1, employee.getEname());
        statement.setInt(2, employee.getEsalary());
        statement.setInt(3, employee.getDno());
        statement.setInt(4, employee.getEid());

        n = statement.executeUpdate();

        return n;
    }

    // DELETE
    public int deleteEmployee(int eid)
            throws ClassNotFoundException, SQLException {

        int n = 0;

        Connection connection = DBUtil.getDBConnection();

        PreparedStatement statement = connection.prepareStatement(ApplicationProperties.deletesql);

        statement.setInt(1, eid);

        n = statement.executeUpdate();

        return n;
    }

    // FIND BY EMPLOYEE ID
    public Optional<Employee> findEmployee(int eid)
            throws ClassNotFoundException, SQLException {

        Employee employee = null;

        Connection connection = DBUtil.getDBConnection();

        PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findsql);

        statement.setInt(1, eid);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            employee = new Employee();

            employee.setEid(resultSet.getInt("eid"));
            employee.setEname(resultSet.getString("ename"));
            employee.setEsalary(resultSet.getInt("esalary"));
            employee.setDno(resultSet.getInt("dno"));
        }

        return Optional.of(employee);
    }

    // FIND ALL EMPLOYEES
    public List<Employee> findAllEmployee()
            throws ClassNotFoundException, SQLException {

        List<Employee> employeeList = new ArrayList<>();

        Connection connection = DBUtil.getDBConnection();

        PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findAllsql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {

            Employee employee = new Employee();

            employee.setEid(resultSet.getInt("eid"));
            employee.setEname(resultSet.getString("ename"));
            employee.setEsalary(resultSet.getInt("esalary"));
            employee.setDno(resultSet.getInt("dno"));

            employeeList.add(employee);
        }

        return employeeList;
    }
}
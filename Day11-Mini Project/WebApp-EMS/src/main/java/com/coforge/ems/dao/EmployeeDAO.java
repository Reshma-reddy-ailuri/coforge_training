package com.coforge.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;
import com.coforge.ems.util.DBUtil;

public class EmployeeDAO {

	public int createEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		int n = 0;
		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.insertSql);
		statement.setInt(1, employee.getEid());
		statement.setString(2, employee.getEname());
		statement.setInt(3, employee.getEsalary());
		statement.setInt(4, employee.getDno());

		n = statement.executeUpdate();
		return n;
	}

	public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();
		int n = 0;

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updateSql);
		statement.setString(1, employee.getEname());
		statement.setInt(2, employee.getEsalary());
		statement.setInt(3, employee.getDno());
		statement.setInt(4, employee.getEid());

		n = statement.executeUpdate();
		return n;
	}

	public int deleteEmployee(int eid) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();
		int n = 0;

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.deleteSql);
		statement.setInt(1, eid);

		n = statement.executeUpdate();
		return n;
	}

	public List<Employee> finalAllEmployee() throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();
		List<Employee> list = new ArrayList<>();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findAllSql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setEid(resultSet.getInt("eid"));
			employee.setEname(resultSet.getString("ename"));
			employee.setEsalary(resultSet.getInt("esalary"));
			employee.setDno(resultSet.getInt("dno"));
			list.add(employee);
		}
	

		return list;
	}

	public Employee findEmployee(int eid) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();
		Employee employee = null;

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findSql);
		statement.setInt(1, eid);

		ResultSet resultSet = statement.executeQuery();
	
		if (resultSet.next()) {
			employee = new Employee();
			employee.setEid(resultSet.getInt("eid"));
			employee.setEname(resultSet.getString("ename"));
			employee.setEsalary(resultSet.getInt("esalary"));
			employee.setDno(resultSet.getInt("dno"));
		}

		return employee;
	}

}

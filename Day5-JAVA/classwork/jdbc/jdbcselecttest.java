package com.coforge.day5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcselecttest {

	public static void main(String[] args) throws Exception {

		// Step 1: Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");

		// Step 3: Create PreparedStatement
		String sql = "SELECT * FROM tbl_emp";
		PreparedStatement statement = connection.prepareStatement(sql);

		// Step 4: Execute Query
		ResultSet resultSet = statement.executeQuery();
        
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("eid") + " " + resultSet.getString("ename") + " "
					+ resultSet.getInt("esalary") + " " + resultSet.getInt("dno"));
		}

		// Step 5: Close Resources
		resultSet.close();
		statement.close();
		connection.close();
	}
}
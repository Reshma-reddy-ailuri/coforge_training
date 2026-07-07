package com.coforge.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		
		// step1 : Loading Driver
		Class.forName(ApplicationProperties.driver);

		// step2:Connection with DB (driver manager is a class)
		Connection connection = DriverManager.getConnection(ApplicationProperties.url, ApplicationProperties.userName, ApplicationProperties.password);
		return connection;//returning db connection object

	}

}

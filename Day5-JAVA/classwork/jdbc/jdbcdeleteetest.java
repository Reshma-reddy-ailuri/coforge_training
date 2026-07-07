package com.coforge.day5.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class jdbcdeleteetest {
	public static void main(String[] args) throws Exception {
		//step1 : Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step2:Connection with DB (driver manager is a class)
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root");
		
		//Step3: Creating Statement (preparedstatement is an interface)
		 String sql = "DELETE FROM tbl_emp WHERE eid=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// step4:Executing the query
		statement.setInt(1, 101);
		
		int n = statement.executeUpdate(); //method for INSERT,UPDATE AND DELETE QUERIES.
		if(n>0) {
			System.out.println("Employee deleted successfully");
		}else {
			System.out.println("Employee details not deleted");
		}
		
		//step5: closing
		statement.close();
		connection.close();
	}

}

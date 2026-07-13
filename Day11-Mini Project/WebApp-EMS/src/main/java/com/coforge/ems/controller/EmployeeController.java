package com.coforge.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private EmployeeService service = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int eid = Integer.parseInt(request.getParameter("eid"));
		PrintWriter out = response.getWriter();
		String result = "";
		try {
			Employee employee = service.findEmployee(eid);
			if(employee != null) {
			result = employee.getEname() + " " + employee.getEsalary() + " " + employee.getDno();
			out.println(result);
			}else {
				result = "null 0 0";
				out.println(result);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidEmployeeObjectException e) {
			e.printStackTrace();
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("emsButton");

		int eid = 0;
		String ename = "";
		int esalary = 0, dno = 0;
		Employee employee = null;

		String result = "";

		switch (action) {
		case "Insert":
			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			esalary = Integer.parseInt(request.getParameter("esalary"));
			dno = Integer.parseInt(request.getParameter("dno"));
			employee = new Employee(eid, ename, esalary, dno);
			try {
				int n = service.createEmployee(employee);
				if(n == 1) {
					result = ApplicationProperties.insertSuccess;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			
			response.sendRedirect("index.jsp?result=" + result);
			break;
			
		case "Update":
			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			esalary = Integer.parseInt(request.getParameter("esalary"));
			dno = Integer.parseInt(request.getParameter("dno"));
			employee = new Employee(eid, ename, esalary, dno);
			try {
				int n = service.updateEmployee(employee);
				if(n == 1) {
					result = ApplicationProperties.updateSuccess;
				}else {
					result = ApplicationProperties.notFound;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			
			response.sendRedirect("index.jsp?result=" + result);
			break;
			
		case "Delete":
			eid = Integer.parseInt(request.getParameter("eid"));
	
			try {
				int n = service.deleteEmployee(eid);
				if(n == 1) {
					result = ApplicationProperties.deleteSuccess;
				}else {
					result = ApplicationProperties.notFound;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			
			response.sendRedirect("index.jsp?result=" + result);
			break;
			
		case "Find":
			eid = Integer.parseInt(request.getParameter("eid"));
			
			try {
				employee = service.findEmployee(eid);
				if(employee != null)
					result = URLEncoder.encode(employee.toString(), StandardCharsets.UTF_8);
				else
					result = ApplicationProperties.notFound;	
					
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			
			response.sendRedirect("index.jsp?result=" + result);
			break;
			
		case "FindAll":
			List<Employee> employees = null;
			try {
				employees = service.findAllEmployee();
//			     for(Employee emp : employees) {
//			    	 result += emp.toString() + "\n";
//	
//			     }
		    	 result = URLEncoder.encode(employees.toString(), StandardCharsets.UTF_8);
			  
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} 
			response.sendRedirect("index.jsp?result=" + result);
			
			break;

		}
	}
}

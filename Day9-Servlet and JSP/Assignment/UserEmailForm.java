package com.coforge.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEmailForm
 */
@WebServlet("/UserEmailForm")
public class UserEmailForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>User Details</h2>");
		out.println("<br> <h3>Name: " +name+ "</h3>");
		out.println("<br> <h3>Email: " +email+ "</h3>");
		
	}

}

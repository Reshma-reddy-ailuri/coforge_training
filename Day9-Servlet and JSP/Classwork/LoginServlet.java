package com.coforge.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login") // this is url pattern
public class LoginServlet extends HttpServlet {
	// Overriding doPost method from HttpServlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("admin") && password.equals("123")) {
			//out.println("<b><font color='green'>Welcome Admin </b></font>");
			HttpSession session = request.getSession(); //creating a session object
			session.setAttribute("username", username); //key-value pair
			
			Cookie cookie = new Cookie("username",username);
			response.addCookie(cookie);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("LoginSuccess.jsp");
		} else {
			//out.println("<b><font color='red'>Invalid Username or Password </b></font>");
			response.sendRedirect("LoginFail.jsp");
		}
	}

}

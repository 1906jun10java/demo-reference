package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {
	
	private AuthenticationService authService = new AuthenticationService();
	
	// servlets should have ONLY code related to handling requests and formatting responses
	// all application logic should be occurring in service classes

	/*
	 * doGet: this method will handle all GET requests made to this servlet
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// write a message to the response body with PrintWriter
		//resp.getWriter().write("hello from Login Servlet!");
		
		//serve the Login.html page as the response
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	/*
	 * doPost: this method will handle all POST requests made to this servlet
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// grab credentials from request
		Credentials creds = new Credentials(req.getParameter("username"), req.getParameter("password"));
		User u = authService.authenticateUser(creds);
		if (u != null) {
			resp.getWriter().write("welcome, "+u.getFirstname()+" "+u.getLastname());
		} else {
			resp.getWriter().write("invalid credentials");
		}
	}

}

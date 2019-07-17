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

	// servlets should have ONLY code related to handling requests and formatting
	// responses
	// all application logic should be occurring in service classes

	/*
	 * doGet: this method will handle all GET requests made to this servlet
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// write a message to the response body with PrintWriter
		// resp.getWriter().write("hello from Login Servlet!");

		// serve the Login.html page as the response
		// RequestDispatcher is used to perform a 'forward' - passing request to another
		// resource without the client's awareness
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
			// resp.getWriter().write("welcome, "+u.getFirstname()+" "+u.getLastname());
			// redirect user to their profile page if authenticated
			resp.sendRedirect("profile");
		} else {
			// what if the creds are wrong?
			
			// Option 1: print a sassy message (not super useful)
			// resp.getWriter().write("invalid credentials, nerd");
			
			// Option 2: redirect back to login
			// resp.sendRedirect("login");
			
			// Option 3: send back a status code of 403 and a message
			// TO BE CONTINUED... WHAT IF THERE'S AN ERROR PAGE DEFINED?
			resp.sendError(403, "invalid credentials");
		}
	}

}

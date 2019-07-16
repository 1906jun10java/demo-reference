package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/*
	 * doGet: this method will handle all GET requests made to this servlet
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// write a message to the response body with PrintWriter
		//resp.getWriter().write("hello from Login Servlet!");
		
		//serve the Login.html page as the response
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}

}

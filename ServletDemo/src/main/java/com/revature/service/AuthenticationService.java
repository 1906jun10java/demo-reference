package com.revature.service;

import com.revature.beans.Credentials;
import com.revature.beans.User;

public class AuthenticationService {

	public AuthenticationService() {
	}
	
	// return a User object if a valid user exists 
	// otherwise return null
	public User authenticateUser(Credentials creds) {
		User u =  null;
		if (creds.getUsername().equals("merlin") && creds.getPassword().equals("cat")) {
			u = new User(6, "Merlin", "Higgins", creds.getUsername(), "merlin@wizcat.com");
		}
		return u;
	}

}

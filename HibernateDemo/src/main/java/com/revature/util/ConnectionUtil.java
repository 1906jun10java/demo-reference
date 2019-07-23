package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// if no sessionFactory has been create, make one
			Configuration c = new Configuration();
			c.setProperty("hibernate.connection.username", System.getenv("DEMO_DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("DEMO_DB_PASSWORD"));
			c.setProperty("hibernate.connection.url", System.getenv("DEMO_DB_URL"));
			c.configure(); // by default, looks for a hibernate.cfg.xml in src/main/resources
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
	}

}

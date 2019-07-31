package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConnectionFromFile(String filename) throws SQLException {
		Connection c = null;
		try {
			Properties prop = new Properties();
			InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream(filename);
			prop.load(in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("pass"));
		} catch (ClassNotFoundException ex) {
			System.out.println("unable to load driver class!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}

}

package com.revature.main;

import java.util.List;

import com.revature.beans.Bear;
import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOImpl;

public class Driver {

	public static void main(String[] args) {
		/*
		 * try { Connection con =
		 * ConnectionUtil.getConnectionFromFile("connection.properties");
		 * System.out.println(con); } catch (SQLException e) { e.printStackTrace(); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		BearDAO bd = new BearDAOImpl();
		//List<Bear> bearList = bd.getBears();
		//Bear berneice = bd.getBearById(2);
		System.out.println(bd.feedBear(1003, 1001, 5000));
	}

}

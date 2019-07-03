package com.reavture.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reavture.dao.SuperHeroDAO;
import com.revature.beans.SuperHero;
import com.revature.util.ConnFactory;

public class SuperHeroDAOImpl implements SuperHeroDAO {
	public static ConnFactory cf= ConnFactory.getInstance();
	
	public void createSuperHero(String heroName) throws SQLException {
		Connection conn= cf.getConnection();
		String sql= "{ call INSERTSUPERHERO(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
		
	}

	public List<SuperHero> getSuperHeroList() throws SQLException {
		// Statement- compiled on SQL side, generally not safe
		//bad for sql injection
		List<SuperHero> superHeroList= new ArrayList<SuperHero>();
		Connection conn =cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM SUPERHERO");
		SuperHero s=null;
		while(rs.next()) {
			s= new SuperHero(rs.getInt(1),rs.getString(2));
			superHeroList.add(s);
		}
		
		return superHeroList;
	}

}

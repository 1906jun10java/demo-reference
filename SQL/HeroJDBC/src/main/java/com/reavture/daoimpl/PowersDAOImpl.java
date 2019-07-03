package com.reavture.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.reavture.dao.PowersDAO;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowersDAO {
	public static ConnFactory cf= ConnFactory.getInstance();

	public void createPowers(String powerName) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "INSERT INTO POWERS VALUES(POWSEQ.NEXTVAL,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, powerName);
		ps.executeUpdate();
		
	}
	
}

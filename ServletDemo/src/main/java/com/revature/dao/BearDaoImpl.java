package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class BearDaoImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.BIRTHDATE, B.WEIGHT, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME "
					+ "FROM BEAR B INNER JOIN BEAR_TYPE BT ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID "
					+ "LEFT JOIN CAVE C ON B.CAVE_ID = C.CAVE_ID ORDER BY B.BEAR_ID";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int bearId = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_NAME");
				double weight = rs.getDouble("WEIGHT");
				LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				int bearTypeId = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				bl.add(new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears), new BearType(bearTypeId, bearTypeName), weight, birthdate));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public Bear getBearById(int id) {
		Bear b = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.BIRTHDATE, B.WEIGHT, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME "
					+ "FROM BEAR B INNER JOIN BEAR_TYPE BT ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID "
					+ "LEFT JOIN CAVE C ON B.CAVE_ID = C.CAVE_ID "
					+ "WHERE B.BEAR_ID = ?";
			PreparedStatement pstmt  = con.prepareStatement(sql);
			pstmt.setInt(1, id); //we index from 1 in prepared statement placeholders
			ResultSet rs = pstmt.executeQuery(); //if we wanted to change anything, use executeUpdate()
			// map the ResultSet onto a Bear object
			if (rs.next()) {
				int bearId = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_NAME");
				double weight = rs.getDouble("WEIGHT");
				LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				int bearTypeId = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				b = new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears), new BearType(bearTypeId, bearTypeName), weight, birthdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean createBear(Bear bear) {
		return false;
	}

	@Override
	public void updateBear(Bear bear) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBear(Bear bear) {
		// TODO Auto-generated method stub

	}

}

package com.reavture.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperHero;

public interface SuperHeroDAO {
	//crud ops
	public abstract void createSuperHero(String heroName)
			throws SQLException;
	public abstract List<SuperHero> getSuperHeroList()
			throws SQLException;
}

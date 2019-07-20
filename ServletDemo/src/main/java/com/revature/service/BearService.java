package com.revature.service;

import java.util.List;

import com.revature.beans.Bear;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;

public class BearService {
	
	private BearDao bd = new BearDaoImpl(); // this is the only line I have to change to swap out dao implementation

	public BearService() {
	}
	
	public List<Bear> getBears() {
		return bd.getBears();
	}
	
	public Bear getBearById(int id) {
		return bd.getBearById(id);
	}
	
	public boolean createBear(Bear bear) {
		return bd.createBear(bear);
	}

}

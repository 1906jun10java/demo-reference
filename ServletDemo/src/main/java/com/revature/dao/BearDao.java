package com.revature.dao;

import java.util.List;

import com.revature.beans.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public boolean createBear(Bear bear);
	public void updateBear(Bear bear);
	public void deleteBear(Bear bear);

}

package com.revature.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;

public class FakeBearDaoImpl implements BearDao {
	
	private List<Bear> allBears = new ArrayList<>();

	public FakeBearDaoImpl() {
		//pre-populate with some bears
		BearType bt = new BearType(4, "Grizzly");
		Cave c = new Cave(57, "Tampa", 12);
		this.allBears.add((new Bear(3, "Joshua", c, bt, 650, LocalDate.of(2005, Month.APRIL, 28))));
		this.allBears.add((new Bear(8, "Smokey", c, bt, 200, LocalDate.of(1944, Month.JULY, 4))));
	}

	@Override
	public List<Bear> getBears() {
		return allBears;
	}

	@Override
	public Bear getBearById(int id) {
		for (Bear bear : allBears) {
			if (bear.getId()==(id)) {
				return bear;
			}
		}
		return null;
	}

	@Override
	public boolean createBear(Bear bear) {
		allBears.add(bear);
		return true; // this is only hardcoded because we're not actually persisting anything and nothing can go wrong!
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

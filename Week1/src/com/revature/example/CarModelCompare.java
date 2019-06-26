package com.revature.example;

import java.util.Comparator;

import com.revature.beans.Car;

public class CarModelCompare implements Comparator<Car> {

	@Override
	public int compare(Car arg0, Car arg1) {
		return arg0.getModel().compareTo(arg1.getModel());
	}
}

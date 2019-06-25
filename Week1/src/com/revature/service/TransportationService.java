package com.revature.service;

import com.revature.beans.Car;
import com.revature.exception.MaintenanceException;

public class TransportationService {

	// any checked exceptions which can be thrown within the method must be listed
	// in the declaration
	public void drive(Car c) throws MaintenanceException {

		// make sure you actually have a car to work with - avoid NullPointerExceptions!
		// (these are unchecked exceptions)
		if (c != null) {
			if (c.getFuelLevel() > 0) {
				System.out.println(c.getMake() + " " + c.getModel() + " is driving");
			} else {
				throw new MaintenanceException("not enough fuel");
			}
		}

	}
}

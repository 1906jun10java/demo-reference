package com.revature;

import com.revature.beans.Car;
import com.revature.exception.MaintenanceException;
import com.revature.service.TransportationService;

public class Driver {

	public static void main(String[] args) {

		// create a TransportationService instance
		TransportationService ts = new TransportationService();
		try {
			ts.drive(null); // we had to write a null check here!
			// now, throw an exception
			Car c2 = new Car(1997, "Mustang", "Mustang", 0.0);
			ts.drive(c2);
		} catch (MaintenanceException m) {
			m.printStackTrace();
		}

		// c2.getModel();
		// another block scope example - c2 is not defined outside of try block!
		// from compiler's perspective, there is no guarantee that c2 exists

		// no exceptions thrown from this!
		Car c = new Car(1998, "Mustang", "Mustang", 90.0);
		try {
			ts.drive(c);
		} catch (MaintenanceException e) {
			e.printStackTrace();
		} catch (Exception e) { // unnecessary here, but this is valid because Exception is more general than
								// MaintenanceException
			e.printStackTrace();
		}
		// for later: try-with-resources!
	}

}

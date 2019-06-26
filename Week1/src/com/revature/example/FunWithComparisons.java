package com.revature.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.revature.beans.Car;

public class FunWithComparisons {

	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car(1997, "Mustang", "Mustang", 0.0));
		carList.add(new Car(1999, "Nissan", "GTR", 0.0));
		carList.add(new Car(1993, "Porsche", "911 Turbo S", 0.0));
		carList.add(new Car(2014, "Ford", "Taurus", 0.0));
		carList.add(new Car(2035, "Tesla", "Spaceship", 100.0));
		System.out.println("Cars before sort:");
		printCars(carList);
		sortWithComparable(carList);
		System.out.println("Cars after sort with Comparable:");
		printCars(carList);
	}
	
	static void sortWithComparable(List<Car> cars) {
		Collections.sort(cars);
	}
	
	static void printCars(List<Car> cars) {
		Iterator<Car> it = cars.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

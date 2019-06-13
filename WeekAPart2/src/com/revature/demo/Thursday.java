package com.revature.demo;

// imports every class in the beans package (search at one level with the wildcard *)
import com.revature.beans.*; // just saves you typing 
// import com.revature.beans.Car; => just the Car class
// import static com.revature.somepackage.ClassInSomePackage.* => all static members of ClassInSomePackage
// import static com.revature.somepackage.ClassInSomePackage.STATICMEMBER => just STATICMEMBER
// import static java.lang.Math.PI; 

public class Thursday {

	public static void main(String[] args) {
		
		funWithVehicles();
		

	}
	
	public static void funWithVehicles() {
		// fully qualified classname = package.Classname, works every time
		com.revature.beans.Car c  = new com.revature.beans.Car(1997, "Mazda", "Sundance");
	}

}

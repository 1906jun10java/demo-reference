import java.util.Arrays; // just saves you typing! 

public class Hello {

	public static void main(String[] args) {
		funWithArrays(new Car(1997, "Mazda", "Sundance"), new Boat("blue", "Tracker"), new Boat("red", "Champion"));
	}


	// overloaded funWithArrays
	public static void funWithArrays(Vehicle v1, Vehicle v2, Vehicle v3) {
		// put Vehicles in array and print it out
		Vehicle[] vehicles = {v1, v2, v3};
		System.out.println(Arrays.toString(vehicles));
	}
	

	public static void funWithArrays() {
		// how to create an array
		String[] arr1 = {"this", "is", "an", "array"};
		String[] arr2 = new String[3]; // indices 0-2
		arr2[0] = "also";
		arr2[1] = "an";
		arr2[2] = "array";
		// iterate through an array
		// regular for loop
		for (int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}	
		// enhanced (augmented) for loop to iterate through Array or Iterable
		for (String s : arr2) {
			System.out.println(s);
		}
		// for printing arrays...
		System.out.println("toString from Array: "+arr2.toString());
		System.out.println("toString from Arrays utility class: "+Arrays.toString(arr2));
	}
	
	public static void init() {
		System.out.println("Hello World!");
		// create a Marker object
		Marker m1 = new Marker();	// default constructor
		m1.setInkColor("blue");
		m1.setMarkerType("permanent");
		System.out.println(m1); 	// this will print the toString of an Object 	
		Marker m2 = new Marker();
		m2.setInkColor("green");
		m2.setMarkerType("dry-erase");
		System.out.println(m2);
	}

	public static void travel() {
		
		// instantiate a new Boat
		Boat b = new Boat();
		b.setColor("green");
		b.setName("Stingray");
		
		// instantiate a new Boat with our new constructor 
		Boat b2 = new Boat("gray", "Dolphin");
	
		// instantiate a new Car
		Car c = new Car(1992, "Chrysler", "New Yorker");
		
		// make an array of Vehicles
		Vehicle[] vehicles = {b, b2, c};
		for (int i=0; i<vehicles.length; i++) {
			vehicles[i].move();
		}
	}
}

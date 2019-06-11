public class Hello {

	public static void main(String[] args) {
		travel();
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

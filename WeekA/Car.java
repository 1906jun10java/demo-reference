public class Car extends Vehicle {

	public Car() {
		super();
	}
	public Car(int yearManufactured, String make, String model) {
		this.yearManufactured = yearManufactured;
		this.make = make;
		this.model = model;
	}

	// static variable defining recommended miles between oil changes
	public static int recommendedMilesBetweenOilChanges = 5000;	

	// private instance variables, accessible only within class and related to a specific Car
	private int yearManufactured;
	private String make;
	private String model;
	private int milesSinceOilChange;

	// getters and setters 
	public int getYearManufactured() {
		return this.yearManufactured;
	}
	public String getMake() {
		return this.make;
	}
	public String getModel() {
		return this.model;
	}
	public int getMilesSinceOilChange() {
		return this.milesSinceOilChange;
	}
	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setMilesSinceOilChange(int milesSinceOilChange) {
		this.milesSinceOilChange = milesSinceOilChange;
	}
	
	@Override 
	public String toString() {
		return "Car: [yearManufactured="+this.yearManufactured+", make="+this.make+", model="+this.model+
			", milesSinceOilChange="+this.milesSinceOilChange+"]";
	}
		
	@Override
	public void move() {
		System.out.println(this.toString()+" is moving");
	}
}

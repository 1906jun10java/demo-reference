package com.revature.funfactory;

public class Car {
	private String make;
	private int year;
	private String model;
	private String color;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String make, int year, String model, String color) {
		super();
		this.make = make;
		this.year = year;
		this.model = model;
		this.color = color;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [make=" + make + ", year=" + year + ", model=" + model + ", color=" + color + "]";
	}
	
	
}

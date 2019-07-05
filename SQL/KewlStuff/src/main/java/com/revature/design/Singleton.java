package com.revature.design;

public class Singleton {
	
	/*
	 * Singleton Design Pattern
	 * ensure a class has only one instance and provides
	 * a global access to it
	 * GOOD FOR SCANNER
	 */
	//private static property of the self class
	private static Singleton instance;
	//private constructor
	private Singleton() {
		//logic here
	}
	//Static method to get the unique instance- if it does not exist
	//we will create it
	public static synchronized Singleton getInstance() {
		if(instance==null) {
			instance= new Singleton();
		}
		return instance;
	
	}
	public void doSomething() {
		//what the object should do
	}
	
}

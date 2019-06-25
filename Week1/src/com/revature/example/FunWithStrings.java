package com.revature.example;

public class FunWithStrings {

	public static void main(String[] args) {
		
		// create a new String
		String a = "hello";
		String b = new String("hello");
		
		/*
		 * .equals() - inherited from Object, used to check "equality" not "identity"
		 * String overrides this to compare the literals 
		 */
		System.out.println("String a is equal to String b: "+a.equals(b));
		
		/*
		 * == to compare primitives OR the value of a REFERENCE 
		 * check whether the objects a and b are the same object
		 */
		System.out.println("String a is the same object as String b: "+ (a == b));
		
		// a and b are different objects which point to the same literal in the string pool
	}

}

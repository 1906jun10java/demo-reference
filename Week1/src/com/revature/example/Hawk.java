package com.revature.example;

class Raptor extends Bird {

	static {
		System.out.println("in first static block in raptor");
		System.out.println("r1");
	}

	public Raptor() {
		super();
		System.out.println("in raptor constructor body");
		System.out.println("r2");
	}

	{
		System.out.println("in first instance block in raptor");
		System.out.println("r3");
	}
	static {
		System.out.println("in second static block in raptor");
		System.out.println("r4");
	}
}

public class Hawk extends Raptor {

	public static void main(String[] args) {
		System.out.println("init");
		new Hawk();
		System.out.println("hawk");
	}
	
	public Hawk() {
		super();
		System.out.println("in hawk constructor body");
	}

}

class Bird {
	{
		System.out.println("in instance block in bird");
		System.out.println("b1");
	}

	Bird() {
		super();
		System.out.println("in bird constructor body");
		System.out.println("b2");
	}

	static {
		System.out.println("in static block in bird");
		System.out.println("b3");
	}
}
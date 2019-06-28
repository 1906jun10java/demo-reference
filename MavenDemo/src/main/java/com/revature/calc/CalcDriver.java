package com.revature.calc;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class CalcDriver {

	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {

		Double inputA = 0.0;
		Double inputB = 0.0;
		Double answer;
		Calculator c = new Calculator();
		Scanner kb = new Scanner(System.in);
		boolean keepGoing = true;

		do {
			try {

				int menuSelection = getMenuSelection(kb);

				System.out.println("What is your first number?");
				inputA = getNumber(kb);
				log.info("first user input: " + inputA);

				System.out.println("What is your second number?");
				inputB = getNumber(kb);
				log.info("second user input: " + inputB);

				answer = c.doMath(menuSelection, inputA, inputB);

				System.out.println("Your answer is: " + answer);

				keepGoing = false;
				
			} catch (Exception e) {
				log.error("Threw Exception: " + e);
				System.out.println("Try again ;)");
				kb.nextLine();
			}
		} while (keepGoing);

	}

	static int getMenuSelection(Scanner in) {
		System.out.println("what would you like to do ?" + "\n" + " 1. Add" + "\n" + " 2. Subtract" + "\n"
				+ " 3. Multiply" + "\n" + " 4. Divide");
		System.out.print("Please enter the basic operation you would like to perform: ");
		return in.nextInt();
	}

	static Double getNumber(Scanner in) {
		return Double.parseDouble(in.next());
	}

}

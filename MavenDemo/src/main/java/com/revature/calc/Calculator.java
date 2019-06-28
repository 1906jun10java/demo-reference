package com.revature.calc;

import org.apache.log4j.Logger;

public class Calculator {
	
	private static Logger log = Logger.getRootLogger();
	
	public double doMath(int menuSelection, double inputA, double inputB) throws CalculatorException {
		double answer = 0;
		switch (menuSelection) {
		case 1:
			answer = inputA + inputB;
			break;
		case 2:
			answer = inputA - inputB;
			break;
		case 3:
			answer = inputA * inputB;
			break;
		case 4:
			answer = inputA / inputB;
			break;
		default:
			throw new CalculatorException("invalid selection of operation");
		}
		log.info("calculated answer to be: "+answer);
		return answer;

	}
}
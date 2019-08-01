package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.revature.beans.Animal;
import com.revature.exception.GotEatenException;

@Service
public class CircleOfLifeService {
	// logging is a CROSS-CUTTING CONCERN which we should be handling as an ASPECT
	// private static Logger log = Logger.getRootLogger();
	
	/**
	 * 
	 * @param a1 animal doing the chasing
	 * @param a2 animal being chased
	 * @throws GotEatenException when pursuer is hungry and also faster
	 */
	public void chase(Animal a1, Animal a2) throws GotEatenException {
		// log.info(a1+" is chasing "+a2);
		if (a1.getSpeed() > a2.getSpeed()) {
			this.capture(a1, a2);
		}
	}
	
	/**
	 * 
	 * @param a1 animal which has captured the other
	 * @param a2 animal which has been captured
	 * @throws GotEatenException if a1 is hungry
	 */
	public void capture(Animal a1, Animal a2) throws GotEatenException {
		// log.warn(a1 +" caught "+a2);
		if (a1.isHungry()) {
			// log.fatal(a1+" ate "+a2);
			throw new GotEatenException();
		}
	}

}

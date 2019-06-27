package com.revature.logging;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.*;

public class LoggingDemo {
	
	private static Logger log =  Logger.getRootLogger();//LogManager.getLogger(LoggingDemo.class);

	public static void main(String[] args) {
	
		allTheLogs();

	}
	
	static void allTheLogs() {
		log.trace("trace message");
		log.debug("debug message");
		log.info("info message");
		log.warn("warn message");
		log.error("error message");
		log.fatal("fatal message");
	}

}

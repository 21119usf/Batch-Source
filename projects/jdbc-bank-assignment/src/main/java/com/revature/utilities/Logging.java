package com.revature.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {	
	
	static Logger logger = LogManager.getLogger(Logging.class);
	
	public static void log(String message) {
		
		logger.info("this is set to info: " + message);
	}
}
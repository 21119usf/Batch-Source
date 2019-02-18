package com.revature.bap1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	
	static Logger logger = LogManager.getLogger(Logging.class);
	
	public void log(String message) {
		
		logger.info("this is set to info: " + message);
		logger.warn("this is set to warn: " + message);
		logger.error("This is set to error: " + message);
		logger.fatal("This is set to fatal: " + message);
	}
}

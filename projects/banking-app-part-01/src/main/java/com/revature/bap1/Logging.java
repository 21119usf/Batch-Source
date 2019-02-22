package com.revature.bap1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	
	static Logger logger = LogManager.getLogger(Logging.class);
	
	public void log(String message) {
		
		logger.info("this is set to info: " + message);
	}
}

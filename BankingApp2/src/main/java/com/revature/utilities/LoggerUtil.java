package com.revature.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
	static Logger LOGGER = LogManager.getLogger(LoggerUtil.class);
	
	 public void log(String message) {
		LOGGER.info(message);
	}

}

package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Props {
	
	public static Properties getProps() {
		Properties props = new Properties();
		
		try {
			props.load(new FileReader("DB.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

}

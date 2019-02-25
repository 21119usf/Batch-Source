package com.revature.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Props {
	public static Properties getProps() {
		Properties props = new Properties();
		try {
			props.load(new FileReader("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
}

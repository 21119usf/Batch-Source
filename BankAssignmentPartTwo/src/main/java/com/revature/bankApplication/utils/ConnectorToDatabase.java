package com.revature.bankApplication.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectorToDatabase {
	
	private static ConnectorToDatabase connector = new ConnectorToDatabase();
	private ConnectorToDatabase() {
		super();
	}
	public static synchronized ConnectorToDatabase getInstance() {
		if(connector == null) {
			connector = new ConnectorToDatabase();
		}
		return connector;
	}
	
	public static Connection getConnection() {
		Connection connector = null;
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			connector = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connector;
	}

}

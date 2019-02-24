package com.bankapp.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionController {
	private static ConnectionController instance;
	private String propertiesFile = "database.properties";
	
	// Constructor
	private ConnectionController() {
		if (instance == null) {
			instance = new ConnectionController();
		}
	}
	
	// Return instance
	public static synchronized ConnectionController getInstance() {
		return instance;
	}
	
	// Return connection
	public Connection getConnection() {
		Connection c = null;
		Properties p = new Properties();
		try {
			p.load(new FileReader(propertiesFile));
			Class.forName(p.getProperty("driver"));
			c = DriverManager.getConnection(p.getProperty("url"),
				p.getProperty("user"), p.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return c;
	}
}

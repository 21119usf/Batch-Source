package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.bankinterface.CustomerDAOImpl;

public class DAOUtil {
	
	private static Connection connection;
	// gets connection to database 
	public static synchronized Connection getConnection() throws SQLException {
		Properties prop = Props.getProps();
		if (connection == null) {
			try {
				// replace with get property in future
				Class.forName(prop.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			// replace with prop.getPropertry
			connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
		}
		return connection;
	}
	
	public static CustomerDAOImpl CustomerDAO() {
		return new CustomerDAOImpl();
	}
	
//	public static AccountDAOImpl AccountDAO() {
//		return new AccountDAOImpl();
//	}

}

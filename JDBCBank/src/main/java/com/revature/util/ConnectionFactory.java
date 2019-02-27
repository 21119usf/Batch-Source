package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cf = new ConnectionFactory();
	private ConnectionFactory() {
		super();
	}
	public static synchronized ConnectionFactory getInstance() {
		if(cf == null) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try{
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),prop.getProperty("pass"));
		}catch(ClassNotFoundException e) {
				System.out.println("class not found exception");
		}catch(IOException e) {
			System.out.println("io exception");
		}catch(SQLException e) {
			System.out.println("sql");
		}
		return conn;
	}

}

package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
		private static DBConnection cf = new DBConnection();
		
		private DBConnection() {
			super();
		}
		
		public static synchronized DBConnection getInstance() {
			if(cf == null) {
				cf = new DBConnection(); 
			}
			return cf; 
		}
		
		public static Connection getConnection() {
			Connection conn = null; 
			Properties prop = new Properties();
			try {
				prop.load(new FileReader("database.properties"));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
				return conn;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return conn;
		}
}

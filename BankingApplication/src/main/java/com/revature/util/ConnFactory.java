package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
	private static ConnFactory cf = new ConnFactory();
	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {//if connection doesnt exist, make new connection
		if(cf==null) {
			cf=new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn =null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"), 
					prop.getProperty("usr"), 
					prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}

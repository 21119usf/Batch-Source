package com.revature.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnFactory {
	private static ConnFactory cf= new ConnFactory();
	private ConnFactory() {
		super();
	}
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf=new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn= null;
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection
		("jdbc:oracle:thin:@pega21119.cgbbs6xdwjwh.us-west-2.rds.amazonaws.com:1521:ORCL",
					"sgtkitten",
					"pega4life");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}


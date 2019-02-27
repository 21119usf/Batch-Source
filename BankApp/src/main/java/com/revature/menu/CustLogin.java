package com.revature.menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.people.Customer;
import com.revature.util.ConnFactory;
import com.revature.util.InputScan;

public class CustLogin {
	private Customer c = new Customer();
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	public void CustLogMenu() throws SQLException {
		
		String sql;
		System.out.println("Please Enter Your Username and Password." );
		System.out.println("Enter your username: " );
		String input = InputScan.scan.nextLine();
		c.setUserName(input);
		System.out.println();
		System.out.println("Enter your password: ");
		input = InputScan.scan.nextLine();
		c.setPassword(input);
		System.out.println();
		
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn = cf.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT USER_NAME, CUSTOMER_PASSWORD FROM CUSTOMERS "
					+ "WHERE USER_NAME = '"+
			c.getUserName()+"' AND CUSTOMER_PASSWORD = '" + c.getPassword() + "'");
//			rs.next();
			
			if (rs.next()) {
				CustomerMenu cmenu = new CustomerMenu();
				cmenu.CustMenu();
			}else {
				System.out.println("Invalid Input");
				CustLogMenu();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

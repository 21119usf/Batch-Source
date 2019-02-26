package com.revature.views;

import java.sql.SQLException;

import com.revature.daoimpl.CustomerDaoImpl;

public class CustomerView {
	
	private int customerID;
	
	public CustomerView(String username) throws SQLException {
		customerID = new CustomerDaoImpl().getCustomerIDFromUsername(username);
	}
	
	public void frontPage() throws SQLException {
		System.out.println("\nHello " + new CustomerDaoImpl().getFirstLastNameFromCustomerID(customerID) + "!\n");
	
		System.out.println("1. Apply to open a new account");
		System.out.println("3. Look at accounts");
		System.out.println("4. Log out");
	}
}

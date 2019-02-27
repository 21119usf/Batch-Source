package com.revature.bankApplication.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankApplication.beans.Customer;


public interface CustomerDataAccessObject {
	//create read update delete
	public abstract void createCustomer(String username, String password, String firstName, String lastName) throws SQLException;
	public abstract List<Customer> getCustomerList() throws SQLException;
	public abstract void displaySepecificCustomer(String username, String password) throws SQLException;
	public abstract void displayAllCustomer() throws SQLException;
}

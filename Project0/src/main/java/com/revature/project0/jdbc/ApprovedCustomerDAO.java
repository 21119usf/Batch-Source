package com.revature.project0.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.project0.classes.Account;
import com.revature.project0.classes.Customer;

public interface ApprovedCustomerDAO 
{
	ResultSet getAllApprovedCustomers() throws SQLException;
	
	ResultSet getApprovedCustomers(int customerID) throws SQLException;
	
	void updateCustomerBalance(Customer customer) throws SQLException;
	
	void updateCustomerFirstname(String firstname, int customerID) throws SQLException;
	
	void updateCustomerLastname(String lastname, int customerID) throws SQLException;
	
	void updateCustomerAddress(String address, int customerID) throws SQLException;
	
	void insertNewCustomer(Customer customer,Account account) throws SQLException;
	
	void deleteCustomer(Customer customer) throws SQLException;
}

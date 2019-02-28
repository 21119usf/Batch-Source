package com.revature.project0.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.project0.classes.AccountApplication;
import com.revature.project0.classes.Customer;

public interface UnApprovedCustomerDAO 
{
	ResultSet getAllUnApprovedCustomers() throws SQLException;
	
	ResultSet getUnApprovedCustomers(int customerID) throws SQLException;
	
	void addNewUnApprovedCustomer(Customer customer,AccountApplication application) throws SQLException;
	
	void deleteUnApprovedCustomer(Customer customer) throws SQLException;
}

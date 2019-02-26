package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {

	void createCustomer(String username, String password, String firstname, String lastname) throws SQLException;
	List<Customer> getCustomerListNoPassword() throws SQLException;
	boolean doesCustomerIDExist(int customerID) throws SQLException;
	boolean doesCustomerUsernameExist(String username) throws SQLException;
	boolean login(String username, String password) throws SQLException;
	void updateCustomer(String firstName, String lastName, int customerID) throws SQLException;
	void deleteCustomer(int customerID) throws SQLException;
}

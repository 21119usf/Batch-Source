package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {

	void createCustomer(String username, String password, String firstname, String lastname) throws SQLException;
	List<Customer> getCustomerListNoPassword() throws SQLException;
}

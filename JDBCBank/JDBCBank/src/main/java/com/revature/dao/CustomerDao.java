package com.revature.dao;

import java.sql.SQLException;

public interface CustomerDao {
	void createUser(String username, String password, 
			String firstName, String lastName) throws SQLException;
	public void displayCustomer() throws SQLException;
}

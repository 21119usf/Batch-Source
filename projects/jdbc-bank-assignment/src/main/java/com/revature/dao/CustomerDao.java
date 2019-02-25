package com.revature.dao;

import java.sql.SQLException;

interface CustomerDao {

	void createCustomer(String username, String password, String firstname, String lastname) throws SQLException;
}

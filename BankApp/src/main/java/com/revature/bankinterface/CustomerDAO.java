package com.revature.bankinterface;

import java.sql.SQLException;

import com.revature.people.Customer;

public interface CustomerDAO {
		
		public void createCustomer(Customer c) throws SQLException;
		public Customer getCustomer(String username) throws SQLException;
}

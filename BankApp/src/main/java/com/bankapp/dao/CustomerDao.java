package com.bankapp.dao;

import java.sql.SQLException;

import com.bankapp.user.Customer;

public interface CustomerDao {
	public abstract void addCustomer(Customer c) throws SQLException;
	public abstract Customer getCustomer(int id) throws SQLException;
	public abstract void updateCustomer(Customer c) throws SQLException;
	public abstract void deleteCustomer(Customer c) throws SQLException;
}

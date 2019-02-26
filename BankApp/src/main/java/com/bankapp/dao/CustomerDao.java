package com.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bankapp.user.Customer;

public interface CustomerDao {
	public abstract void addCustomer(Customer c) throws SQLException;
	public abstract Customer getCustomer(int id) throws SQLException;
	public abstract Customer getCustomer(String username) throws SQLException;
	public abstract void updateCustomer(Customer c) throws SQLException;
	public abstract void deleteCustomer(Customer c) throws SQLException;
	public abstract ArrayList<Integer> getAccounts(Customer c) throws SQLException;
}

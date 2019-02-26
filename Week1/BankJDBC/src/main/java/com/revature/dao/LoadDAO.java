package com.revature.dao;

import java.sql.SQLException;

import com.revature.bankapp.Account;
import com.revature.bankapp.Customer;

public interface LoadDAO {
	public abstract void clearTables() throws SQLException;
	public abstract void createAccount(Account a) throws SQLException;
	public abstract void createCustomer(Customer c) throws SQLException;
	public abstract void createAccountHolders(Customer c) throws SQLException;
}

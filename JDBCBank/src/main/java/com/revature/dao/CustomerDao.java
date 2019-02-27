package com.revature.dao;

import java.sql.SQLException;

public interface CustomerDao {
	void createCustomer(String firstName, String lastName, String userName, String password) throws SQLException;
	int loginCustomer(String username, String password) throws SQLException;
	void getAccountBalances(int cid) throws SQLException;
	void createNewAccount(int cid) throws SQLException;
	double getBalance(int accId) throws SQLException;
	void deposit(int accId,double bal, double amount,int cid) throws SQLException;
	void withdraw(int accId, double d,int cid) throws SQLException;
	void delete(int accId) throws SQLException;
}

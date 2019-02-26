package com.reavature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.reavture.beans.Account;

public interface UserAccountsDAO {
	ArrayList<Account> getUserAccounts(int userId) throws SQLException;
	void createAccount(Account a) throws SQLException;
	PriorityQueue<Account> getPendingAccounts() throws SQLException;
	void approveAccounts(int accountId) throws SQLException;
	void denyAccount(int accountId) throws SQLException;
	void transfer(Account a, int accountId, double ammount) throws SQLException;
	void closeAccount(int accountId) throws SQLException;
}

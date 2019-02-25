package com.reavature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.reavture.beans.Account;

public interface UserAccountsDAO {
	ArrayList<Account> getUserAccounts(int userId) throws SQLException;
	void createAccount(Account a) throws SQLException;
	PriorityQueue<Account> getPendingAccounts() throws SQLException;
	void approveAccount() thorws SQLException
}

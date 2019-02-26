package com.reavature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.reavture.beans.Account;
/*
 * Interface that is used to define method signatures for any class that is using the UserAccount DAO.
 */
public interface UserAccountsDAO {
	// Method used to get all accounts that belong to a given user based on their id from the DB.
	ArrayList<Account> getUserAccounts(int userId) throws SQLException;
	// Takes an Account object and stores it's values into the DB.
	void createAccount(Account a) throws SQLException;
	// Creates a First In First Out queue for the Admin to address pending account applications one at a time.
	PriorityQueue<Account> getPendingAccounts() throws SQLException;
	// Used to change an accounts DB record status record from "pending" to "open".
	void approveAccounts(int accountId) throws SQLException;
	// Used to change an accounts DB record status from "pending" to "closed".
	void denyAccount(int accountId) throws SQLException;
	// Used to transfer balances from on account DB record to another. 
	void transfer(Account a, int accountId, double ammount) throws SQLException;
	// Used to change an accounts DB record status from "open" to "closed".
	void closeAccount(int accountId) throws SQLException;
}

package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDao {

	void createAccount(int customerID) throws SQLException;
	List<Account> getAccountList() throws SQLException;
	boolean doesAccountIDExist(int accountID) throws SQLException;
	List<Account> getAccountListFromCustomerID(int customerID) throws SQLException;
	boolean doesAccountIDExistAccountIDCustomerID(int accountID, int customerID) throws SQLException;
}

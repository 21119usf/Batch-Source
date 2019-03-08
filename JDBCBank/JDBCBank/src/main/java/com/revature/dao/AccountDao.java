package com.revature.dao;

import java.sql.SQLException;

public interface AccountDao {
	void createAccount(int accountBalance, int CustomerID)throws SQLException;
	void deposit(int value, int accountid)throws SQLException;
}

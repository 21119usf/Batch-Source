package com.revature.bankApplication.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankApplication.beans.Account;

public interface AccountDataAccessObject {
	public abstract void createAccount(int custid, double balance ) throws SQLException;
	public abstract void depositAccount(int accountNumber, double balance ) throws SQLException;
	public abstract void withdrawAccount(int accountNumber, double balance ) throws SQLException;
	public abstract void getBalance(int accountNumber) throws SQLException;
	public abstract List<Account> getAccountList() throws SQLException;

}

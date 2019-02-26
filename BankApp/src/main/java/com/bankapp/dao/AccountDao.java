package com.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bankapp.account.Account;

public interface AccountDao {
	public abstract void addAccount(Account a) throws SQLException;
	public abstract Account getAccount(int id) throws SQLException;
	public abstract void updateAccount(Account a) throws SQLException;
	public abstract void deleteAccount(Account a) throws SQLException;
	public abstract ArrayList<Integer> getCustomers(Account a) throws SQLException;
}

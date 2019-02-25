package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.account.Account;
import com.bankapp.controllers.ConnectionController;

public class AccountDaoImp implements AccountDao {
	public static ConnectionController cc = ConnectionController.getInstance();
	private Connection connection = cc.getConnection();

	// Add account to database
	public void addAccount(Account a) throws SQLException {
		// Convert boolean to int
		int isOpen = a.isOpen() ? 1 : 0;
		
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO ACCOUNT VALUES(" +
				a.getId() + ", " + isOpen + ", " + a.getBalance() + ")";
			statement.executeUpdate(sql);
	}

	// Retrieve account from database by id
	public Account getAccount(int id) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM ACCOUNT " + "WHERE A_ID = " + id;
		int isOpen = 0; double balance = 0.0;
		
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst()) {
			return null;	// No data
		}
		while (rs.next()) {
			isOpen = rs.getInt("A_ISOPEN");
			balance = rs.getDouble("A_BALANCE");
		}
		
		boolean open = isOpen == 0 ? false : true;
		Account a = new Account(open, balance);
		a.setId(id);
		
		return a;
	}

	// Update account in database
	public void updateAccount(Account a) throws SQLException {
		// Convert boolean to int
		int isOpen = a.isOpen() ? 1 : 0;
		
		Statement statement = connection.createStatement();
		String sql = "UPDATE ACCOUNT SET " + 
			"A_ISOPEN = " + isOpen + ", A_BALANCE = " + a.getBalance();
		statement.executeUpdate(sql);
	}

	// Delete account from database
	public void deleteAccount(Account a) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "DELETE FROM ACCOUNT WHERE C_ID = " + a.getId();
		statement.execute(sql);
	}
}

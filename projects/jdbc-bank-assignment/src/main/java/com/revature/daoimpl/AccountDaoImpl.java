package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.ConnFactory;
import com.revature.beans.Customer;
import com.revature.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createAccount(int customerID) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "INSERT INTO ACCOUNT_BANK_APP VALUES (ACCOUNT_ID.NEXTVAL, ?, 0)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, customerID);
		ps.executeUpdate();
	}

	@Override
	public List<Account> getAccountList() throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT_BANK_APP");
		Account a = null;
		while (rs.next()) {
			a = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			accountList.add(a);
		}
		
		return accountList;
	}

	@Override
	public boolean doesAccountIDExist(int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT COUNT(*) FROM ACCOUNT_BANK_APP WHERE AccountID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		if (rs.getInt(1) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Account> getAccountListFromCustomerID(int customerID) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		
		Connection conn = cf.getConnection();
		String sql = "SELECT AccountID, Balance FROM ACCOUNT_BANK_APP WHERE CustomerID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, customerID);
		ResultSet rs = ps.executeQuery();
		
		Account a = null;
		while (rs.next()) {
			a = new Account(rs.getInt(1), rs.getDouble(2));
			accountList.add(a);
		}
		
		return accountList;
	}

	@Override
	public boolean doesAccountIDExistAccountIDCustomerID(int accountID, int customerID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT COUNT(*) FROM ACCOUNT_BANK_APP WHERE AccountID = ? AND CustomerID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountID);
		ps.setInt(2, customerID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		if (rs.getInt(1) == 1) {
			return true;
		} else {
			return false;
		}
	}	
}

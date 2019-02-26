package com.reavature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.reavture.beans.Account;
import com.reavture.beans.AccountStatus;
import com.revature.utilities.DAOUtilities;

public class UserAccountsDAOImpl implements UserAccountsDAO {

	Connection conn;
	PreparedStatement stmt;

	@Override
	public ArrayList<Account> getUserAccounts(int userId) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Account> acct = new ArrayList<Account>();
		conn = DAOUtilities.getConnection();
		String sql = "SELECT * FROM ACCOUNTS WHERE primary_holder_id = ? OR secondary_holder_id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, userId);
		stmt.setInt(2, userId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Account acct1 = new Account();
			acct1.setAccountId(rs.getInt("ACCOUNT_ID"));
			acct1.setPrimaryOwner(rs.getInt("PRIMARY_HOLDER_ID"));
			acct1.setSecondaryOwner(rs.getInt("SECONDARY_HOLDER_ID"));
			acct1.setBalance(rs.getInt("BALANCE"));
			acct1.setStatus(AccountStatus.valueOf(rs.getString("STATUS")));
			acct.add(acct1);
		}
		return acct;
	}

	@Override
	public void createAccount(Account a) throws SQLException {
		conn = DAOUtilities.getConnection();
		String sql = "INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQUENCE.NEXTVAL, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, a.getPrimaryOwner());
		if (a.getSecondaryOwner() != 0) {
			stmt.setInt(2, a.getSecondaryOwner());
		} else {
			stmt.setNull(2, java.sql.Types.INTEGER);
		}
		stmt.setDouble(3, a.getBalance());
		stmt.setString(4, AccountStatus.pending.toString());
		stmt.executeUpdate();
	}

	@Override
	public PriorityQueue<Account> getPendingAccounts() throws SQLException {
		PriorityQueue<Account> queue = new PriorityQueue<Account>();
		conn = DAOUtilities.getConnection();
		String sql = "SELECT * FROM ACCOUNTS WHERE STATUS='pending'";
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Account a = new Account();
			a.setAccountId(rs.getInt("ACCOUNT_ID"));
			a.setPrimaryOwner(rs.getInt("PRIMARY_HOLDER_ID"));
			a.setSecondaryOwner(rs.getInt("SECONDARY_HOLDER_ID"));
			a.setBalance(rs.getDouble("BALANCE"));
			a.setStatus(AccountStatus.valueOf(rs.getString("STATUS")));
			queue.add(a);
		}
		return queue;
	}

	@Override
	public void approveAccounts(int accountId) throws SQLException {
		conn = DAOUtilities.getConnection();
		String sql = "UPDATE ACCOUNTS SET STATUS='open' WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, accountId);
		stmt.executeUpdate();
	}

	@Override
	public void denyAccount(int accountId) throws SQLException {
		conn = DAOUtilities.getConnection();
		String sql = "UPDATE ACCOUNTS SET STATUS='closed' WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, accountId);
		stmt.executeUpdate();
	}

	@Override
	public void transfer(Account a, int accountId, double ammount) throws SQLException {
		conn = DAOUtilities.getConnection();
		String sql = "UPDATE ACCOUNTS SET BALANCE= BALANCE + ? WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, ammount * -1);
		stmt.setInt(2, a.getAccountId());
		stmt.executeUpdate();
		stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, ammount);
		stmt.setInt(2, accountId);
		stmt.executeUpdate();
		return;
	}

	@Override
	public void closeAccount(int accountId) throws SQLException {
		conn = DAOUtilities.getConnection();
		String sql = "UPDATE ACCOUNTS SET STATUS = 'closed' WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, accountId);
		stmt.executeUpdate();
		return;
	}
}

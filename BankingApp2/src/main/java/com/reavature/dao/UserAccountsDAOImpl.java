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
		// create an empty ArrayList to add accounts to from the DB
		ArrayList<Account> acct = new ArrayList<Account>();
		// get a connection to the Database
		conn = DAOUtilities.getConnection();
		// SQL command to run on the DB
		String sql = "SELECT * FROM ACCOUNTS WHERE primary_holder_id = ? OR secondary_holder_id = ?";
		stmt = conn.prepareStatement(sql);
		// fill in placeholder(?) 1 with a value
		stmt.setInt(1, userId);
		// fill in placeholder(?) 2 with a value
		stmt.setInt(2, userId);
		// do the query and store the results in a ResultSet
		ResultSet rs = stmt.executeQuery();
		// while the result set has another account do this loop
		while (rs.next()) {
			// Create Java Object Representation of the Account DB Record 
			Account acct1 = new Account();
			// Set Java Object fields based on DB record columns
			acct1.setAccountId(rs.getInt("ACCOUNT_ID"));
			acct1.setPrimaryOwner(rs.getInt("PRIMARY_HOLDER_ID"));
			acct1.setSecondaryOwner(rs.getInt("SECONDARY_HOLDER_ID"));
			acct1.setBalance(rs.getInt("BALANCE"));
			acct1.setStatus(AccountStatus.valueOf(rs.getString("STATUS")));
			// add account to array list
			acct.add(acct1);
		}
		// return array list
		return acct;
	}

	@Override
	public void createAccount(Account a) throws SQLException {
		// gets DB connection
		conn = DAOUtilities.getConnection();
		// SQL statement to run
		String sql = "INSERT INTO ACCOUNTS VALUES(ACCOUNTS_ID_SEQUENCE.NEXTVAL, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		// set DB records Primary_Holder field to the accounts primary holder
		stmt.setInt(1, a.getPrimaryOwner());
		// set DB records Secondary_Holder field to the accounts secondary holder if it is set (Joint Account)
		if (a.getSecondaryOwner() != 0) {
			stmt.setInt(2, a.getSecondaryOwner());
		} else {
			// if Account dose not have a Secondary_Holder set placeholder (?) to null 
			stmt.setNull(2, java.sql.Types.INTEGER);
		}
		// set Balance placeholder (?) in SQL string
		stmt.setDouble(3, a.getBalance());
		// set the DB record role placeholder (?) in SQL String
		stmt.setString(4, AccountStatus.pending.toString());
		// run the now placeholder free SQL command on the DB
		stmt.executeUpdate();
	}

	@Override
	public PriorityQueue<Account> getPendingAccounts() throws SQLException {
		// create the PiorityQueue that will hold all pending accounts
		PriorityQueue<Account> queue = new PriorityQueue<Account>();
		// get DB Connection
		conn = DAOUtilities.getConnection();
		// SQL string to run on the DB
		String sql = "SELECT * FROM ACCOUNTS WHERE STATUS='pending'";
		stmt = conn.prepareStatement(sql);
		// Run the BD query and place result into a ResultSet object
		ResultSet rs = stmt.executeQuery();
		// While ResultSet has queue items do this loop
		while(rs.next()) {
			// create new Account and set values based on DB record values
			Account a = new Account();
			a.setAccountId(rs.getInt("ACCOUNT_ID"));
			a.setPrimaryOwner(rs.getInt("PRIMARY_HOLDER_ID"));
			a.setSecondaryOwner(rs.getInt("SECONDARY_HOLDER_ID"));
			a.setBalance(rs.getDouble("BALANCE"));
			a.setStatus(AccountStatus.valueOf(rs.getString("STATUS")));
			// add parsed Account to queue
			queue.add(a);
		}
		return queue;
	}

	@Override
	public void approveAccounts(int accountId) throws SQLException {
		// Get DB Connection
		conn = DAOUtilities.getConnection();
		// SQL string to run on the DB
		String sql = "UPDATE ACCOUNTS SET STATUS='open' WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		// Set the account id placeholder in the sql string
		stmt.setInt(1, accountId);
		// run DB update
		stmt.executeUpdate();
	}

	@Override
	public void denyAccount(int accountId) throws SQLException {
		// get connection
		conn = DAOUtilities.getConnection();
		// SQL to run on DB
		String sql = "UPDATE ACCOUNTS SET STATUS='closed' WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		// set placeholder (?)
		stmt.setInt(1, accountId);
		// run DB update
		stmt.executeUpdate();
	}

	@Override
	public void transfer(Account a, int accountId, double ammount) throws SQLException {
		//get connection
		conn = DAOUtilities.getConnection();
		// SQL string to run on the DB
		String sql = "UPDATE ACCOUNTS SET BALANCE= BALANCE + ? WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		// Set balance placeholder in SQL String
		stmt.setDouble(1, ammount * -1);
		// Set account id in SQL String
		stmt.setInt(2, a.getAccountId());
		// run DB operation
		stmt.executeUpdate();
		// Do it again for the 2nd account 
		stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, ammount);
		stmt.setInt(2, accountId);
		stmt.executeUpdate();
		return;
	}

	@Override
	public void closeAccount(int accountId) throws SQLException {
		// get connection
		conn = DAOUtilities.getConnection();
		// SQL string to run in DB
		String sql = "UPDATE ACCOUNTS SET STATUS = 'closed' WHERE ACCOUNT_ID=?";
		stmt = conn.prepareStatement(sql);
		// set account id placeholder (?)
		stmt.setInt(1, accountId);
		// run DB command
		stmt.executeUpdate();
		return;
	}
}

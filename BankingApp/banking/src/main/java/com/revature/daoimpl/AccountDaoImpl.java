package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.banking.AdminAccess;
import com.revature.beans.Account;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;
import com.revature.util.ExceptionCatcher;

public class AccountDaoImpl implements AccountDao {
	private static Logger logger = LogManager.getLogger(AccountDao.class);
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	public List<Account> getAccountList(int userID) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE USER_ID=" + userID);
		Account s = null;
		while(rs.next()) {
			
			Double balance = rs.getDouble(2);
			Double rounded = (double) Math.round(balance*100d)/100d;
			s = new Account(rs.getInt(1),rounded); 
			accountList.add(s);
		}
		
		return accountList;
	}
	public List<Integer> pullAccountID(int userID) throws SQLException {
		int accID=0;
		List<Integer> accountID = new ArrayList<Integer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE USER_ID=" + userID);
		while (rs.next()) {
			
			accID = rs.getInt(1);
			accountID.add(accID);
		}
		return accountID;
	}

	public Double pullAccountBalance(int accID) throws SQLException {
		Double balance=(double) 0;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_ID=" + accID);
		while (rs.next()) {
			balance = rs.getDouble(2);
			Double rounded = (double) Math.round(balance*100d)/100d;
			balance = rounded;
		}
		
		return balance;
	}

	public void withdrawFunds(int accID, Double withdraw, int userID) throws SQLException {
		Double balance=(double) 0;
		Double newBalance = (double) 0;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_ID=" + accID);
		while (rs.next()) {
		balance = rs.getDouble(2);
		Double rounded = (double) Math.round(balance*100d)/100d;
		balance = rounded;
		newBalance = balance - withdraw;
		if (newBalance < 0) {
			System.out.println("OVERDRAFT WARNING; You cannot withdraw more than your current balance of $" + balance);
		}
		else {
			String sql = "{ call UPDATE_ACC_BALANCE(?,?)";
			CallableStatement call=conn.prepareCall(sql);
			call.setInt(1, accID);
			call.setDouble(2, newBalance);
			call.execute();
			System.out.println("Withdrawal of $" + withdraw + " successful. New balance is $" + newBalance);
			logger.info("User " + userID + " withdrew $" + withdraw + " from account " + accID);
		}
		
		}
	}

	public void depositFunds(int accID, Double deposit, int userID) throws SQLException {
		Double balance=(double) 0;
		Double newBalance = (double) 0;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_ID=" + accID);
		while (rs.next()) {
		balance = rs.getDouble(2);
		Double rounded = (double) Math.round(balance*100d)/100d;
		balance = rounded;
		newBalance = balance + deposit;
		String sql = "{ call UPDATE_ACC_BALANCE(?,?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setInt(1, accID);
		call.setDouble(2, newBalance);
		call.execute();
		System.out.println("Deposit of $" + deposit + " successful. New balance is $" + newBalance);
		logger.info("User " + userID + " deposited $" + deposit + " to account " + accID);
		}
		
	}

	public void transferFunds(int accID, int targAccID, Double transfer, int userID) throws SQLException {
		Double fromBalance=(double) 0;
		Double targNewBalance = (double) 0;
		Double fromNewBalance = (double) 0;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_ID=" + targAccID);
		if (rs.next()) {
		Double targBalance = rs.getDouble(2);
		Double rounded = (double) Math.round(targBalance*100d)/100d;
		targBalance = rounded;
		rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_ID=" + accID);
		while (rs.next()) {
		fromBalance = rs.getDouble(2);
		rounded = (double) Math.round(fromBalance*100d)/100d;
		fromBalance = rounded;
		fromNewBalance = fromBalance - transfer;
		if (fromNewBalance < 0) {
			System.out.println("OVERDRAFT WARNING; Transfer exceeds the current balance of $" + fromBalance);
		}
		else {
			targNewBalance = targBalance + transfer;
			String sql = "{ call UPDATE_ACC_BALANCE(?,?)";
			CallableStatement call=conn.prepareCall(sql);
			call.setInt(1, accID);
			call.setDouble(2, fromNewBalance);
			call.execute();
			sql = "{ call UPDATE_ACC_BALANCE(?,?)";
			call=conn.prepareCall(sql);
			call.setInt(1, targAccID);
			call.setDouble(2, targNewBalance);
			call.execute();
			
			System.out.println("Transfer of $" + transfer + " to account " + targAccID + 
					" successful. \nNew balance in account " + accID + " is $" + fromNewBalance);
			logger.info("User " + userID + " transferred $" + transfer + " from account " + accID + " to account " + targAccID);
		}
		}
	}
		else {
			System.out.println("There is no account with the number " + targAccID + ". Please try again.");
		}
	}

	public void createAccount(Double startBal, int userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call CREATEACCOUNT(?,?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setDouble(1, startBal);
		call.setInt(2, userID);
		call.execute();
		System.out.println("Account created!");
		
	}

	@Override
	public void deleteAccount(int accID, int userID) throws SQLException {
		ExceptionCatcher ec = new ExceptionCatcher();
		Scanner input = new Scanner(System.in);
		Double balance=(double) 0;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_ID=" + accID);
		while (rs.next()) {
			balance = rs.getDouble(2);
			Double rounded = (double) Math.round(balance*100d)/100d;
			balance = rounded;
		}
		if (balance>0) {
			System.out.println("This account still has a balance of $" + balance + "! What would you like to do?");
			System.out.println("1 - Withdraw $" + balance);
			System.out.println("2 - Transfer $" + balance + " to another account");
			System.out.println("0 - Cancel");
			input = new Scanner(System.in);
			String choiceStr = input.nextLine();
			Integer choice =ec.parseIntCheck(choiceStr);
			switch (choice) {
			case 1:
					System.out.println("You have withdrawn $" + balance);
					String sql = "{ call DELETE_ACCOUNT(?)";
					CallableStatement call=conn.prepareCall(sql);
					call.setDouble(1, accID);
					call.execute();
					System.out.println("Account " + accID + " deleted!");
					logger.info("User " + userID + " deleted " + accID);
				break;
			case 2:
				System.out.println("Please input the account number you wish to transfer the remaining balance to, or type 0 to go back:");
				input = new Scanner(System.in);
				String targAccStr = input.nextLine();
				Integer targAcc =ec.parseIntCheck(targAccStr);
				if (targAcc==0) {
					break;
				}
				else {
				rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACC_ID=" + targAcc);
				if (rs.next()) {
				Double targBalance = rs.getDouble(2);
				Double rounded = (double) Math.round(targBalance*100d)/100d;
				targBalance = rounded;
				Double targNewBalance = targBalance + balance;
				sql = "{ call UPDATE_ACC_BALANCE(?,?)";
				call=conn.prepareCall(sql);
				call.setInt(1, targAcc);
				call.setDouble(2, targNewBalance);
				call.execute();
				sql = "{ call DELETE_ACCOUNT(?)";
				call=conn.prepareCall(sql);
				call.setDouble(1, accID);
				call.execute();
				System.out.println("Account " + accID + " deleted!");
				logger.info("User " + userID + " deleted " + accID);
				}
				}
				break;
			case 0:
				break;
			}
			
		}
		
		else {
		conn = cf.getConnection();
		String sql = "{ call DELETE_ACCOUNT(?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setDouble(1, accID);
		call.execute();
		System.out.println("Account " + accID + " deleted!");
		logger.info("User " + userID + " deleted " + accID);
		}

	}

}

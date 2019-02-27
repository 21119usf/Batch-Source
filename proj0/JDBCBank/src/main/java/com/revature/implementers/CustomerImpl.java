package com.revature.implementers;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.interfaces.UserInterface;
import com.revature.util.ConnFactory;

public class CustomerImpl implements UserInterface{
	ArrayList<Object> customerList = new ArrayList<Object>();
	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn = cf.getConnection();
	double balance;
	String sql;
	
	public List<Object>viewAccount(int userID) throws SQLException{
		Statement stmt =  conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT*FROM CUSTOMERS WHERE USER_ID IN (SELECT USER_ID FROM USERS WHERE USER_ID="+userID+")");
		Customer c = null;
		while(rs.next()) {
			c=new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8));
			c.setAccoutID(rs.getInt(10));
			customerList.add(c);
		}
		return customerList;
	}
	public double viewAccountBalance(int acctID) throws SQLException {
		Statement stmt =  conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT BALANCE FROM CHECKINGACCOUNT WHERE ACCOUNT_ID="+acctID);
		double balance = 0;
		while(rs.next()) {
			balance = rs.getDouble(1);
		}
		return balance;
		
	}
	public double withdraw(int acctID, double amount) throws SQLException{
		sql = "{ call WITHDRAWCHECKING(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, acctID);
		call.setDouble(2, amount);
		call.execute();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT BALANCE FROM CHECKINGACCOUNT WHERE ACCOUNT_ID="+acctID);
		rs.next();
		balance = rs.getDouble(1);
		return balance;
	}
	
	public double deposit(int acctID, double amount) throws SQLException {
		sql = "{ call DEPOSITCHECKING(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, acctID);
		call.setDouble(2, amount);
		call.execute();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT BALANCE FROM CHECKINGACCOUNT WHERE ACCOUNT_ID="+acctID);
		rs.next();
		balance = rs.getDouble(1);
		return balance;
	}
	
	public double[] trasnfer(int acctID, int rtng_number, long acct_number, double amount) throws SQLException {
		double[] balances = new double[2];
		sql = "{ call ACCTTRANSFER(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, acctID);
		call.setInt(2,rtng_number);
		call.setLong(3, acct_number);
		call.setDouble(4, amount);;
		call.execute();
		Statement stmt1 = conn.createStatement();
		ResultSet rs1 = stmt1.executeQuery("SELECT BALANCE FROM CHECKINGACCOUNT WHERE ROUTING_NUMBER ="+rtng_number+" AND ACCOUNT_NUMBER="+acct_number);
		rs1.next();
		balances[0]=rs1.getInt(1);
		Statement stmt2 = conn.createStatement();
		ResultSet rs2 = stmt2.executeQuery("SELECT BALANCE FROM CHECKINGACCOUNT WHERE ACCOUNT_ID ="+acctID);
		rs2.next();
		balances[1]=rs2.getInt(1);
		return balances;
	}
	
	public void cancelAccount(int custUserID, int acctID) throws SQLException{
		balance = viewAccountBalance(acctID);
		Scanner myScanner = new Scanner(System.in);		
		if(balance>0) {
			System.out.println("Sorry, but this account is not empty. Current Balance is $"+balance);
			System.out.println("Would you like to cashout then cacnel?");
			String answer = myScanner.nextLine().toLowerCase();
			if(answer.equals("yes")) {
				balance = withdraw(acctID, balance);
				System.out.println("Cashout Successful. Remaining Balance is $"+balance);
				sql = "{ call CANCELACCT(?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, custUserID);
				call.setInt(2, acctID);
				call.execute();
				System.out.println("Account Canceled... Enjoy your new bank -_-");
				myScanner.close();
			}
		}else if(balance<0){
			System.out.println("!ATTENTION! This account overdraw... Please contact the customer service in order to perform cancelation.\n"
					+ "Balance is $"+balance);
		}else {
			sql = "{ call CANCELACCT(?,?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, custUserID);
			call.setInt(2, acctID);
			call.execute();
			System.out.println("Account Canceled... Notifying the customer of the depressing news XD");
			myScanner.close();
		}
	}

}

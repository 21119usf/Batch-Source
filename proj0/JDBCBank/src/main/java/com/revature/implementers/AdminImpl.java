package com.revature.implementers;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.interfaces.AdminInterface;

public class AdminImpl extends CustomerImpl implements AdminInterface{
	
	List<CustomerLookUp> accts = new ArrayList<CustomerLookUp>();
	
	public void viewAllAccountIDs() throws SQLException{
		Statement stmt =  conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FIRSTNAME, LASTNAME, ACCOUNT_ID, USER_ID FROM CUSTOMERS");
		CustomerLookUp cl = null;
		while(rs.next()) {
			cl = new CustomerLookUp(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			//accts.add(cl);
			System.out.println(cl.toString2());
		}
		//return accts;
	}
	

	@Override
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
				System.out.println("Account Canceled... Notifying the customer of the depressing news XD");
				myScanner.close();
			}
		}else if(balance<0){
			System.out.println("!ATTENTION! This account overdraw... Please contact the customer before performing cancelation.\n"
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

	@Override
	public double viewAccountBalance(int acctID) throws SQLException {
		Statement stmt =  conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT BALANCE FROM CHECKINGACCOUNT WHERE ACCOUNT_ID="+acctID);
		double balance = 0;
		while(rs.next()) {
			balance = rs.getDouble(1);
		}
		return balance;
		
	}
	
	public void viewAPendingAccounts() throws SQLException {
		Statement stmt =  conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FIRSTNAME, LASTNAME, DOB, STREET, CITY, STATE, PHONE#, EMAIL, USER_ID FROM PENDINGACCOUNTS");
		CustomerLookUp pendAccts; 
		while(rs.next()) {
			pendAccts = new CustomerLookUp(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			System.out.println(pendAccts.toString1());
			
		}
	}
	
	public void approveAccount(int userID) throws SQLException{	
		sql = "{ call APPROVEACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.execute();
		System.out.println("Account Approved... Notifying the customer of the good news!");
		
	}
	public void denyAccount(int userID) throws SQLException{
		sql = "{ call DenyAccount(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.execute();
		System.out.println("Account Denied... Notifying the customer of the sad news...");
	}

}

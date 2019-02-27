package com.revature.implementers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.interfaces.EmployeeInterface;
import com.revature.util.ConnFactory;

public class EmployeeImpl implements EmployeeInterface{
	
	ArrayList<Object> customerList = new ArrayList<Object>();
	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn = cf.getConnection();
	double balance;
	String sql;
	List<CustomerLookUp> accts = new ArrayList<CustomerLookUp>();
	
	public EmployeeImpl() {
		
	}
	
	@Override
	public void viewAllAccountIDs() throws SQLException {
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

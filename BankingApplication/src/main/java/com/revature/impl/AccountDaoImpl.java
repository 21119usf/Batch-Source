package com.revature.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.accounttype.IndividualAccount;
import com.revature.util.ConnFactory;

public class AccountDaoImpl {
	
	public static ConnFactory cf=ConnFactory.getInstance();
	
	public void createAccount(int userID, float accountBal)throws SQLException{
		
		Connection conn = cf.getConnection();
		String sql = "{ call CREATEINDIVIDUALACCOUNT(?, ?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setInt(1, userID);
		call.setFloat(2, accountBal);
		call.execute();	
	}
	
	public List<IndividualAccount> getAccountList() throws SQLException {
		
		List<IndividualAccount> accountList = new ArrayList<IndividualAccount>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM INDIVIDUALACCOUNT");
		IndividualAccount s=null;
		
		while(rs.next()) {
			s=new IndividualAccount(rs.getFloat(1), rs.getInt(2), rs.getInt(3));
			accountList.add(s);
		}
		
		return accountList;
	}

	public float getBalance(int userId) throws SQLException{
	
		float b = 0.0f;
		Connection conn = cf.getConnection();
		
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT ACCOUNTBAL FROM INDIVIDUALACCOUNT WHERE USERID ='"+userId+"'");
		if(rs.next()) {
			 b = rs.getFloat(1);
		}
		return b;		
	}
	
	public void accountDeposit(int userID, float depositAmount)throws SQLException{
		
		Connection conn = cf.getConnection();
		String sql = "{ call ADDTOBALANCE(?, ?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setInt(1, userID);
		call.setFloat(2, depositAmount);
		call.execute();	
	}
	
	public int getAccount(int userId) throws SQLException{
		
		int a=0;
		Connection conn = cf.getConnection();
		
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT ACCOUNTNUM FROM INDIVIDUALACCOUNT WHERE USERID ='"+userId+"'");
		if(rs.next()) {
			 a = rs.getInt(1);
		}
		return a;		
	}
	public void deleteAccount(int uid) throws SQLException{
		
		Connection conn = cf.getConnection();		
		Statement stmt=conn.createStatement();
		stmt.executeQuery("DELETE FROM INDIVIDUALACCOUNT WHERE USERID ='"+uid+"'");	
	}
	
}

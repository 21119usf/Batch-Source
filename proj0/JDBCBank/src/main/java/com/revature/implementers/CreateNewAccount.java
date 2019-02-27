package com.revature.implementers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.interfaces.CreateNewAccountInterface;
import com.revature.util.ConnFactory;

public class CreateNewAccount implements CreateNewAccountInterface{
	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn = cf.getConnection();
	String sql;
	
	public void createNewAccount(String fName, String lName, String DOB, String str, String city, String st,String cell, String email, 
			String usr, String pass) throws SQLException {
		sql = "{ call NEWACCOUNT(?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, fName);
		call.setString(2, lName);
		call.setString(3, DOB);
		call.setString(4, str);
		call.setString(5, city);
		call.setString(6, st);
		call.setString(7, cell);
		call.setString(8, email);
		call.setString(9, usr);
		call.setString(10, pass);
		call.execute();
		System.out.println("Request Recieved... Your account is currently pending.");
	}

}

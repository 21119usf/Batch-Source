package com.revature.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.users.CustomerUser;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao {
	public static ConnFactory cf=ConnFactory.getInstance();
	

	public void createUser(String firstName, String lastName, String userName, String passWord)throws SQLException{
		
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTUSER(?, ?, ?, ?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setString(1, firstName);
		call.setString(2, lastName);
		call.setString(3, userName);
		call.setString(4, passWord);
		call.execute();		
	}

	public List<CustomerUser> getUserList(int userID) throws SQLException {
		
		List<CustomerUser> userList = new ArrayList<CustomerUser>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM CUSTOMERUSER WHERE USERID = '"+userID+"'");
		CustomerUser s=null;
		
		while(rs.next()) {
			s=new CustomerUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			userList.add(s);
		}
		
		return userList;
	}
	
	public List<CustomerUser> userSearch(String userName, String passWord) throws SQLException{
		
		List<CustomerUser> userList = new ArrayList<CustomerUser>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT USERID FROM CUSTOMERUSER WHERE USERNAME ='"+userName+"' AND PASSWORD1='"+passWord+"'");
		CustomerUser s=null;
		
		while(rs.next()) {
			s=new CustomerUser(rs.getString(4), rs.getString(5));
			userList.add(s);
		}
		return userList;
	}
	

	public List<CustomerUser> userID() throws SQLException{
		
		List<CustomerUser> userList = new ArrayList<CustomerUser>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM CUSTOMERUSER");
		CustomerUser s=null;
		
		while(rs.next()) {
			if(rs.getString(4).equals("idiot2")) 
			s=new CustomerUser(rs.getInt(1));
			userList.add(s);
		}
		return userList;
	}
	
	public int getUserId(String userName, String passWord) throws SQLException{
		
		int b=0;
		Connection conn = cf.getConnection();
		
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT USERID FROM CUSTOMERUSER WHERE USERNAME ='"+userName+"' AND PASSWORD1='"+passWord+"'");
		//CustomerUser s=null;
		if(rs.next()) {
			 b = rs.getInt(1);
		}
		return b;		
	}
	
	public void deleteUser(int uid) throws SQLException{
		
		Connection conn = cf.getConnection();		
		Statement stmt=conn.createStatement();
		stmt.executeQuery("DELETE FROM CUSTOMERUSER WHERE USERID ='"+uid+"'");	
	}
	
	public void updateName(int uid, String first, String last) throws SQLException{
		
		Connection conn = cf.getConnection();		
		Statement stmt=conn.createStatement();
		stmt.executeQuery("UPDATE CUSTOMERUSER SET FIRSTNAME ='"+first+"' , LASTNAME='"+last+"' "
				+ "WHERE USERID ='"+uid+"'");	
	}
	
	public void updateLogin(int uid, String uname, String pword) throws SQLException{
		
		Connection conn = cf.getConnection();		
		Statement stmt=conn.createStatement();
		stmt.executeQuery("UPDATE CUSTOMERUSER SET USERNAME ='"+uname+"' , PASSWORD1='"+pword+"' "
				+ "WHERE USERID ='"+uid+"'");	
	}

}

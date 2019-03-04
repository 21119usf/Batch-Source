package com.revature.daoimpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.bank.User;
import com.revature.dao.UserDao;
import com.revature.util.DBConnection;

public class UserDaoImpl implements UserDao{
	public static DBConnection cf = DBConnection.getInstance(); 
	//GET USER
	@Override
	public User getUser(String name) {
		try (Connection con = DBConnection.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT * " + "FROM users WHERE username = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getString("username"), rs.getString("password"), rs.getFloat("balance"),
						rs.getBoolean("admin"), rs.getBoolean("approval"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}
	//CREATE USERS 
	@Override
	public void createUser(User user) throws SQLException {
		Connection conn = DBConnection.getConnection(); 
		String sql = "{ call INSERTUSER(?,?,?,?,?)"; 
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, user.username);
		call.setString(2, user.password);
		call.setFloat(3, user.balance);
		call.setBoolean(4, user.admin);
		call.setBoolean(5, user.approval);
		call.execute();
	}
	//GET ALL USERS 
	@Override
	public ArrayList<User> getAllUsers() throws SQLException {
		ArrayList<User> temp = new ArrayList<User>(); 
		try (Connection con = DBConnection.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT * " + "FROM users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString("username"), rs.getString("password"), rs.getFloat("balance"),
						rs.getBoolean("admin"), rs.getBoolean("approval"));
				temp.add(u); 
			}
			printAllUsers(temp); 
			return temp; 
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}
	
		//PRINT TABLES
		public void printAllUsers(ArrayList<User> users) {
			        System.out.println("=========|  " +"USERNAME"+ "  |========" + "=========|  "  +"BALANCE"+ " |========"  + "=========|  " +"PASSWORD"+ "  |========"  + "========|  "  +"APPROVAL"+     "   |========" + "=======|"+  "ENTITY"+"  |========");
			for(User x : users) {
				if(x.admin)
					System.out.println("=========|  " +x.username+"  |========" + "=============| " +  x.balance+"       |========" + "=======|  "  +x.password+ "   |========" + " =========|  "   +x.approval+    "   |========" + "==========| ADMIN |==========");
				else
					System.out.println("=========|  " +x.username+"  |========" + "=============| " +  x.balance+"       |========" + "=======|  "  +x.password+"    |========" + " =========|  "   +x.approval+    "   |========" + "===========|CUSTOMER|========");
 
			}
					System.out.println("====================================================================================================================================================");
		}
		
		//APROVE USERS 
		@Override
		public void approveUser(User user) throws SQLException {
				Connection conn = DBConnection.getConnection(); 
				String sql = "{ call APPROVEUSER(?)"; 
				CallableStatement call = conn.prepareCall(sql);
				call.setString(1, user.username);
				call.execute();			
		}
		//UPDATE USER
		@Override
		public void editUser(User user) throws SQLException {
			Connection conn = DBConnection.getConnection(); 
			String sql = "{ call UPDATEUSER(?,?,?,?,?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, user.username);
			call.setString(2, user.password);
			call.setFloat(3, user.balance);
			call.setBoolean(4, user.admin);
			call.setBoolean(5, user.approval);
			call.execute();
		}
		//GET USER ID
		@Override
		public int getUserId(String username, String password) throws SQLException {
			int b=0;
			Connection conn = DBConnection.getConnection();
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT USERID FROM users WHERE username ='"+username+"' AND password='"+password+"'");
			//CustomerUser s=null;
			if(rs.next()) {
				 b = rs.getInt(1);
			}
			return b;
		}
		//DELETE USER
		@Override
		public void deleteUser(int uid) throws SQLException {
			Connection conn = DBConnection.getConnection();		
			Statement stmt=conn.createStatement();
			stmt.executeQuery("DELETE FROM users WHERE userid ='"+uid+"'");
		}
		//GET BALANCE
		@Override
		public float getBalance(String username) throws SQLException {
			int b=0;
			Connection conn = DBConnection.getConnection();
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT balance FROM users WHERE username ='"+username+"'");
			//CustomerUser s=null;
			if(rs.next()) {
				 b = rs.getInt(1);
			}
			return b;
		}
		//CREATE ACCOUNT FOR USERS 
		@Override
		public void createAccount(String username, float balance) throws SQLException {
			Connection conn = DBConnection.getConnection(); 
			String sql = "{ call CREATEACCOUNT(?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, username);
			call.execute();
		}	
		//SET BALANCE
		@Override
		public void setBalance(String username, float amount) throws SQLException {
			Connection conn = DBConnection.getConnection(); 
			String sql = "{ call UPDATEBALANCE(?,?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, username);
			call.setFloat(2, amount);
			call.execute();
			
		}
		//GET ACCOUNT NUMBER
		@Override
		public int getAccountNum(String username) throws SQLException {
			int b=0;
			Connection conn = DBConnection.getConnection();
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT accountNum FROM account WHERE username ='"+username+"'");
			//CustomerUser s=null;
			if(rs.next()) {
				 b = rs.getInt(1);
			}
			return b;
		}	
}

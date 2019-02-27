package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class AdminDaoImpl {
	
	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	
	public void viewAccounts() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANKCUSTOMER FULL OUTER JOIN BANKACCOUNT ON BANKCUSTOMER.CID=BANKACCOUNT.CID ORDER BY BANKCUSTOMER.LASTNAME";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("\t-"+rs.getString("LASTNAME")+" "+rs.getString("FIRSTNAME")+"\tCustomer ID: "+rs.getInt("CID")+" \tAccount number: "+rs.getInt("AID")+"\tBalance:"+rs.getString("BALANCE"));
		}
		
	}
	public void delete(int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call REMOVECUSTOMER("+cid+")";	
		CallableStatement call = conn.prepareCall(sql);
		call.execute(sql);
	}
	public double getBalance(int accId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM BANKACCOUNT WHERE AID='"+accId+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getDouble("BALANCE");
	}
	public void updatefirstName(String firstName, int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE BANKCUSTOMER SET FIRSTNAME='"+firstName+"' WHERE CID="+cid;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}
	public void updatelastName(String lastName, int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE BANKCUSTOMER SET USERNAME='"+lastName+"' WHERE CID="+cid;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}
	public void updateusername(String username, int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE BANKCUSTOMER SET USERNAME='"+username+"' WHERE CID="+cid;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}
	public void updatepassword(String password, int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE BANKCUSTOMER SET PASSWORD='"+password+"' WHERE CID="+cid;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}


}

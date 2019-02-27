package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.dao.CustomerDao;
import com.revature.util.ConnectionFactory;

public class CustomerDaoImpl implements CustomerDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();

	public void createCustomer(String firstName, String lastName, String userName, String password)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call CREATECUSTOMER(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,firstName);
		call.setString(2,lastName);
		call.setString(3,userName);
		call.setString(4,password);
		call.execute();
		
	}
	public int loginCustomer(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANKCUSTOMER WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt("CID");
	}
	
	public void getAccountBalances(int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT AID, BALANCE FROM BANKACCOUNT WHERE CID='"+cid+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int accID;
		double bal;
		while(rs.next()) {
			accID = rs.getInt("AID");
			bal = rs.getDouble("BALANCE");
			System.out.println("\tAccount ID:"+accID);
			System.out.println("\tBalance:"+bal);
		}	
	}
	
	public void createNewAccount(int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO BANKACCOUNT VALUES(AID_SEQ.NEXTVAL,"+cid+","+0+")";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}
	public double getBalance(int accId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM BANKACCOUNT WHERE AID='"+accId+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getDouble("BALANCE");
	}
	public void deposit(int accId,double bal, double amount,int cid) throws SQLException {
		Connection conn = cf.getConnection();
		double newBalance = bal+amount;
		String sql = "UPDATE BANKACCOUNT SET BALANCE="+newBalance+" WHERE AID="+accId+" AND CID="+cid;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}
	public void withdraw(int accId, double d,int cid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql="UPDATE BANKACCOUNT SET BALANCE="+d+" WHERE AID="+accId+" AND CID="+cid;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}
	public void delete(int accId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM BANKACCOUNT WHERE AID="+accId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();		
	}
}
	




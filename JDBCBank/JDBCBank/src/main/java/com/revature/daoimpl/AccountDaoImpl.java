package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dao.AccountDao;
import com.revature.driver.AdminMenu;
import com.revature.driver.ConnFactory;
import com.revature.driver.CustomerMenu;
import com.revature.driver.Driver;

public class AccountDaoImpl implements AccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createAccount(int accountBalance, int CustomerID) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTACCOUNT(?,?)";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, accountBalance);
		cs.setInt(2, CustomerID);
		cs.execute();
	}
	public void findAccount(int CustomerID) throws SQLException{
		Connection conn = cf.getConnection();
        Statement statement = conn.createStatement();

        ResultSet results = statement.executeQuery("SELECT * FROM BANKACCOUNT "
        		+ "WHERE CUSTOMERID = '" + CustomerID + "'");
        
        	CustomerMenu.accountFound = true;
        	AdminMenu.accountFound = true;
	        	while(results.next()) {
	
	            System.out.println("Account ID: " + results.getInt(1) + ", Account Balance: " + results.getInt(2));
	        }
	}
	public void deposit(int account, int amount) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DEPOSIT(?,?)";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, account);
		cs.setInt(2, amount);
		cs.execute();
	}
	public void withdrawal(int account, int amount) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call WITHDRAWAL(?,?)";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, account);
		cs.setInt(2, amount);
		cs.execute();
	}
	public void delete(int account)throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM BANKACCOUNT WHERE ACCOUNTID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, account);
		ps.executeUpdate();
	}
}

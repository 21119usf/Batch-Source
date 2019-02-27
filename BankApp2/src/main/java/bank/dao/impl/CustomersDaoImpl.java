package bank.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bank.beans.Account;
import bank.beans.Customers;
import bank.beans.util.ConnFactory;
import bank.dao.CustomerDao;

public class CustomersDaoImpl implements CustomerDao
{
	final static Logger logger = Logger.getLogger(CustomersDaoImpl.class);
	public static ConnFactory cf = ConnFactory.getInstance();
	private static Connection conn = cf.getConnecton();
	PreparedStatement stmt;
	@Override
	public void createAccount(double balance, String type, int customerID) throws SQLException {
		Connection conn = cf.getConnecton();
		String sql = "{ call CREATEACCOUNT(?,?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1, balance);
		call.setString(2, type);
		call.setInt(3, customerID);
		call.execute();
		logger.info("Account Created");
		
	}
	
	@Override
	public void addCustomer(String fn, String ln, String un, String pw, String address, String ssn, String phoneNum)
			throws SQLException {
		Connection conn = cf.getConnecton();
		String sql = "{ call INSERTCUSTOMER(?,?,?,?,?,?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, fn);
		call.setString(2, ln);
		call.setString(3, un);
		call.setString(4, pw);
		call.setString(5, address);
		call.setString(6, ssn);
		call.setString(7, phoneNum);
		call.execute();
		logger.info("User Created");
	}
	
	@Override
	public void deleteAccount(int aid) throws SQLException {
		Connection conn = cf.getConnecton();
		String sql = "{ call DELETEACCOUNT(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, aid);
		call.execute();
		logger.info("Account Deleted");
		
	}

	@Override
	public void depsoit(double money, int aid) throws SQLException {
		Connection conn = cf.getConnecton();
		String sql = "{ call DEPOSIT(?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1,money);
		call.setInt(2, aid);
		call.execute();
		logger.info("User has depositted money");
	}

	@Override
	public void withdraw(double money, int aid) throws SQLException {
		Connection conn = cf.getConnecton();
		String sql = "{ call WITHDRAW(?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1,money);
		call.setInt(2, aid);
		call.execute();
		logger.info("User has withdrew money");
	}

	@Override
	public List<Account> showAccountInfo(int customerID) throws SQLException {
		List<Account> accList = new ArrayList<Account>();
		Connection conn = cf.getConnecton();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCOUNT WHERE CUSTOMERID = " + customerID);
		Account a = null;
		while(rs.next())
		{
			a=new Account(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getInt(4));
			accList.add(a);
		}
		return accList;
		
	}



	
	

}

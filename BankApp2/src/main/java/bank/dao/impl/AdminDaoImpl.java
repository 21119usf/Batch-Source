package bank.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import bank.beans.util.ConnFactory;
import bank.dao.AdminDao;
import bank.beans.Customers;

public class AdminDaoImpl implements AdminDao
{
	final static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	private static ConnFactory cf = ConnFactory.getInstance();
	private static Connection conn = cf.getConnecton();
	PreparedStatement stmt;
	
	@Override
	public List<Customers> getUser(int id) throws SQLException {
		List<Customers> userList = new ArrayList<Customers>();
		Connection conn = cf.getConnecton();
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT * FROM BANKCUSTOMERS WHERE CUSTOMERID=" +id);
		Customers c = null;
		while(rs.next())
		{
			c=new Customers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			userList.add(c);
		}
		return userList;
	}
	
	@Override
	public void addUser(String fn, String ln, String un, String pw, String address, String ssn, String phoneNum)
			throws SQLException
	{
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
	public void deleteUser(int id) throws SQLException
	{
		Connection conn = cf.getConnecton();
		String sql ="{call deleteUser(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, id);
		call.execute();
		logger.info("User:" + id + " deleted");
	}
}

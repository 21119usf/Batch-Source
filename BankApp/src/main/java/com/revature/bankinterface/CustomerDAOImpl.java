package com.revature.bankinterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.revature.app.Main;
import com.revature.people.Customer;
import com.revature.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {
	
	Connection conn;
	PreparedStatement ps;
	
	
	public static ConnFactory cf = ConnFactory.getInstance();	
	public void createCustomer(Customer c) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CUSTOMERS VALUES(CUSTOMERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ACCOUNTSEQ.NEXTVAL)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, c.getFirstName());
		ps.setString(2, c.getLastName());
		ps.setString(3, c.getSocialSecurity());
		ps.setString(4, c.getUserName());
		ps.setString(5, c.getPassword());
		ps.setString(6, c.getEmail());
		ps.executeUpdate();
		Main.main(null);


	}
	public Customer getCustomer(String username) throws SQLException{
		Customer c = new Customer();
		conn = cf.getConnection();
		String sql = "SELECT * FROM USER WHERE USER_NAME = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			c.setCustomerID(rs.getString("CUSTOMER_ID"));
			c.setFirstName(rs.getString("FIRSTNAME"));
			c.setLastName(rs.getString("LASTNAME"));
			c.setSocialSecurity(rs.getString("SOCIAL_S"));
			c.setUserName(rs.getString("USER_NAME"));
			c.setPassword(rs.getString("CUSTOMER_PASSWORD"));
			c.setEmail(rs.getString("EMAIL"));
			c.setAccountID(rs.getInt("ACCOUNT_ID"));
		} else {
			System.out.println("Invaild Login");
		}
		return c;
	}
	
	public void  deleteUser() throws SQLException{}
	
	
}

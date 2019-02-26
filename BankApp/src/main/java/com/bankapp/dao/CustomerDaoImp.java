package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bankapp.controllers.ConnectionController;
import com.bankapp.user.Customer;

public class CustomerDaoImp implements CustomerDao {
	private static ConnectionController cc = ConnectionController.getInstance();
	private Connection connection = cc.getConnection();
	
	// Add customer to database
	public void addCustomer(Customer c) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO CUSTOMER VALUES(" +
			c.getId() + ", '" + c.getUsername() + "', '" + c.getPassword() + 
			"', '" + c.getFirstName() + "', '" + c.getLastName() + "', '" + 
			c.getEmail() + "', " + c.getPhoneNumber() + ")";
		statement.executeUpdate(sql);
	}

	// Retrieve customer by id
	public Customer getCustomer(int id) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM CUSTOMER " + "WHERE C_ID = " + id;
		
		String username = ""; String password = ""; String firstName = "";
		String lastName = ""; String email = "";
		long phone = 0;
		
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst()) {
			return null;	// No data
		}
		while (rs.next()) {
			username = rs.getString("C_USERNAME");
			password = rs.getString("C_PASSWORD");
			firstName = rs.getString("C_FIRSTNAME");
			lastName = rs.getString("C_LASTNAME");
			email = rs.getString("C_EMAIL");
			phone = rs.getInt("C_PHONE");
		}
		
		Customer c = new Customer(username, password, firstName, lastName,
			email, phone);
		c.setId(id);
		return c;
	}
	
	// Retrieve customer by username
	public Customer getCustomer(String username) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM CUSTOMER " + 
			"WHERE C_USERNAME = '" + username + "'";
		
		String password = ""; String firstName = "";
		String lastName = ""; String email = "";
		long id = 0; long phone = 0;
		
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst()) {
			return null;	// No data
		}
		while (rs.next()) {
			id = rs.getLong("C_ID");
			password = rs.getString("C_PASSWORD");
			firstName = rs.getString("C_FIRSTNAME");
			lastName = rs.getString("C_LASTNAME");
			email = rs.getString("C_EMAIL");
			phone = rs.getLong("C_PHONE");
		}
		
		Customer c = new Customer(username, password, firstName, lastName,
			email, phone);
		c.setId((int)id);
		return c;
	}

	// Update customer in database
	public void updateCustomer(Customer c) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "UPDATE CUSTOMER SET " +
			"C_PASSWORD = '" + c.getPassword() + "', " +
			"C_FIRSTNAME = '" + c.getFirstName() + "', " +
			"C_LASTNAME = '" + c.getLastName() + "', " +
			"C_EMAIL = '" + c.getEmail() + "', " +
			"C_PHONE = " + c.getPhoneNumber() +
			" WHERE C_ID = " + c.getId();
		statement.executeUpdate(sql);
	}

	// Remove customer from database
	public void deleteCustomer(Customer c) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "DELETE FROM CUSTOMER WHERE C_ID = " + c.getId();
		statement.execute(sql);
	}

	// Get customer accounts
	public ArrayList<Integer> getAccounts(Customer c) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "SELECT A_ID FROM CUSTOMER_ACCOUNT " + 
			"INNER JOIN CUSTOMER " + 
			"ON CUSTOMER.C_ID = CUSTOMER_ACCOUNT.C_ID " + 
			"WHERE CUSTOMER_ACCOUNT.C_ID = " + c.getId();
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst()) {
			return null;	// No data
		}
		while (rs.next()) {
			al.add((int)rs.getLong("A_ID"));
		}
		
		return al;
	}
}

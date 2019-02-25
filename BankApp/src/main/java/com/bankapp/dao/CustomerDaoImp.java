package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.controllers.ConnectionController;
import com.bankapp.user.Customer;

public class CustomerDaoImp implements CustomerDao {
	public static ConnectionController cc = ConnectionController.getInstance();
	
	public void addCustomer(Customer c) throws SQLException {
		Connection connection = cc.getConnection();
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO CUSTOMER VALUES(" +
			c.getId() + ", '" + c.getUsername() + "', '" + c.getPassword() + 
			"', '" + c.getFirstName() + "', '" + c.getLastName() + "', '" + 
			c.getEmail() + "', " + c.getPhoneNumber() + ")";
		statement.executeUpdate(sql);
	}

	public Customer getCustomer(int id) throws SQLException {
		Connection connection = cc.getConnection();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM CUSTOMER " + "WHERE C_ID = " + id;
		
		String username = ""; String password = ""; String firstName = "";
		String lastName = ""; String email = "";
		long phone = 0; long social = 0;
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			username = rs.getString("C_USERNAME");
			password = rs.getString("C_PASSWORD");
			firstName = rs.getString("C_FIRSTNAME");
			lastName = rs.getString("C_LASTNAME");
			email = rs.getString("C_EMAIL");
			phone = rs.getInt("C_PHONE");
		}
		
		// Check returned data
		if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() ||
			lastName.isEmpty() || email.isEmpty() || phone == 0 || social == 0) {
			return null;
		}
		
		Customer c = new Customer(username, password, firstName, lastName,
			email, phone);
		c.setId(id);
		return c;
	}
	
	public Customer getCustomer(String username) throws SQLException {
		Connection connection = cc.getConnection();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM CUSTOMER " + 
			"WHERE C_USERNAME = '" + username + "'";
		
		String password = ""; String firstName = "";
		String lastName = ""; String email = "";
		long id = 0; long phone = 0;
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			id = rs.getLong("C_ID");
			password = rs.getString("C_PASSWORD");
			firstName = rs.getString("C_FIRSTNAME");
			lastName = rs.getString("C_LASTNAME");
			email = rs.getString("C_EMAIL");
			phone = rs.getLong("C_PHONE");
		}
		
		// Check returned data
		if (password.isEmpty() || firstName.isEmpty() ||
			lastName.isEmpty() || email.isEmpty() || phone == 0 || id == 0) {
			return null;
		}
		
		Customer c = new Customer(username, password, firstName, lastName,
			email, phone);
		c.setId((int)id);
		return c;
	}

	public void updateCustomer(Customer c) throws SQLException {
		Connection connection = cc.getConnection();
		Statement statement = connection.createStatement();
		String sql = "UPDATE CUSTOMER SET" +
			"C_PASSWORD = " + c.getPassword() + ", " +
			"C_FIRSTNAME = " + c.getFirstName() + ", " +
			"C_LASTNAME = " + c.getLastName() + ", " +
			"C_EMAIL = " + c.getEmail() + ", " +
			"C_PHONE = " + c.getPhoneNumber() + ", " +
			" WHERE C_ID = " + c.getId();
		statement.executeUpdate(sql);
	}

	public void deleteCustomer(Customer c) throws SQLException {
		Connection connection = cc.getConnection();
		Statement statement = connection.createStatement();
	}
}

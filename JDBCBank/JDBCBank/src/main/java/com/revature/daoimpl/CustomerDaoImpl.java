package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.driver.AdminMenu;
import com.revature.driver.ConnFactory;
import com.revature.driver.CustomerMenu;
import com.revature.driver.Driver;

public class CustomerDaoImpl {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUser(String username, String password,
			String firstName, String lastName) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTUSER(?,?,?,?)";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setString(1, username);
		cs.setString(2, password);
		cs.setString(3, firstName);
		cs.setString(4, lastName);
		cs.execute();
	}
	
	public void displayCustomer(String username, String password) throws SQLException {
        Connection conn = cf.getConnection();
        Statement statement = conn.createStatement();

        ResultSet results = statement.executeQuery("SELECT * FROM BANKCUSTOMER "
        		+ "WHERE CUSTOMERUSERNAME = '" + username + "' AND CUSTOMERPASS = '" + password + "'");

        if(results.next()) {

            Driver.userID = results.getInt(1);
            System.out.println("column index for row: " + results.getRow() + ", Customer ID: " + Driver.userID 
            		+ ", Username: " + results.getString(2) + ", Owner: " + results.getString(4) + results.getString(5));
            CustomerMenu.userFound = true;
        }else {
        	System.out.println("Incorrect username/password. Try again.");
        	CustomerMenu.userFound = false;
        }
	}
	public void displayAdmin(String username) throws SQLException{
		Connection conn = cf.getConnection();
        Statement statement = conn.createStatement();

        ResultSet results = statement.executeQuery("SELECT * FROM BANKCUSTOMER "
        		+ "WHERE CUSTOMERUSERNAME = '" + username + "'");

        if(results.next()) {

            Driver.userID = results.getInt(1);
            System.out.println("column index for row: " + results.getRow() + ", Customer ID: " + Driver.userID 
            		+ ", Username: " + results.getString(2) + ", Owner: " + results.getString(4) + " " + results.getString(5));
            AdminMenu.userFound = true;
        }else {
        	System.out.println("User not found. Try again.");
        	AdminMenu.userFound = false;
        }
	}
}
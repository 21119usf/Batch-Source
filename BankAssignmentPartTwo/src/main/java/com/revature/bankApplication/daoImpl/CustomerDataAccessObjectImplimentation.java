package com.revature.bankApplication.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankApplication.Bank;
import com.revature.bankApplication.beans.Customer;
import com.revature.bankApplication.dao.CustomerDataAccessObject;
import com.revature.bankApplication.utils.ConnectorToDatabase;

public class CustomerDataAccessObjectImplimentation implements CustomerDataAccessObject {

	public static ConnectorToDatabase connector = ConnectorToDatabase.getInstance();

	@Override
	public List<Customer> getCustomerList() throws SQLException {
        List<Customer>customerList = new ArrayList<Customer>();
        
        Connection conn = ConnectorToDatabase.getConnection();
		Statement statement = conn.createStatement();

		ResultSet results = statement.executeQuery("SELECT * FROM BANKCUSTOMER");
		
		Customer tempCustomer = null;
		while (results.next()) {
			//String username, String password, String firstname, String lastname, int customerID
			tempCustomer = new Customer (results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5));
			customerList.add(tempCustomer);

		}
        
        return customerList;
    }
	
	
	@Override
	public void createCustomer(String username, String password, String firstName, String lastName)
			throws SQLException {
		Connection conn = ConnectorToDatabase.getConnection();

		String sql = "{ CALL INSERTUSER(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, firstName);
		call.setString(4, lastName);
		call.executeUpdate();

	}

	@Override
	public void displayAllCustomer() throws SQLException {
		Connection conn = ConnectorToDatabase.getConnection();
		Statement statement = conn.createStatement();

		ResultSet results = statement.executeQuery("SELECT * FROM BANKCUSTOMER");

		while (results.next()) {

			// Get the data from the current row using the column index - column data are in
			// the VARCHAR format

			int data1 = results.getInt(1);
			String data2  = results.getString(2);
			String data3 = results.getString(3);
			String data4 = results.getString(4);
			String data5 = results.getString(5);

			System.out.println("column index for row: " + results.getRow() + "  customer id: " + data1 + "  username: " + data2 + 
					"  password: " + data3 + "  first name: " + data4 + "  lastname: " + data5 );
			
		}

	}

	@Override
	public void displaySepecificCustomer(String username, String password) throws SQLException {
		Connection conn = ConnectorToDatabase.getConnection();
		Statement statement = conn.createStatement();

		// ResultSet results = statement.executeQuery("SELECT CUSTID FROM BANKCUSTOMER "
		// + "WHERE USERNAME = '" + username + "' AND USRPASSWORD = '" + password +
		// "'");
		ResultSet results = statement.executeQuery("select bankaccount.custid,firstname,lastname, bankaccount.accountnumber, "
				+ "bankaccount.balance from bankcustomer inner join bankaccount on bankaccount.custid = bankcustomer.custid " 
				+ "WHERE USERNAME = '" + username
				+ "' AND USRPASSWORD = '" + password + "'");

		while (results.next()) {

			// Get the data from the current row using the column index - column data are in
			// the VARCHAR format

			String data1 = results.getString(1);
			String data2 = results.getString(2);
			String data3 = results.getString(3);
			String data4 = results.getString(4);
			String data5 = results.getString(5);
			

			System.out.println("Row Entry" + results.getRow() + "  customer id: " + data1 + "  firstname: " + data2 + 
					"  lastnight: " + data3 + "  account: " + data4 + "  balance: " + data5 );
		}
	}
	
	public void iteratorDisplayAll() {
		
	}

}

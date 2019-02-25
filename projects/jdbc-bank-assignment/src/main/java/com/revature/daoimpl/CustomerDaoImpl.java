package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ConnFactory;
import com.revature.beans.Customer;
import com.revature.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createCustomer(String username, String password, String firstname, String lastname) throws SQLException {
		Connection conn = cf.getConnection();

		String sql = "INSERT INTO CUSTOMER_BANK_APP VALUES (CUSTOMER_ID.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, firstname);
		ps.setString(4, lastname);
		ps.executeUpdate();
	}

	@Override
	public List<Customer> getCustomerListNoPassword() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CUSTOMERID, USERNAME, FIRSTNAME, LASTNAME FROM CUSTOMER_BANK_APP");
		Customer c = null;
		while (rs.next()) {
			c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			customerList.add(c);
		}
		
		return customerList;
	}	
}

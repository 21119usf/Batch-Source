package com.bankapp.account.daoImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.bankapp.controllers.ConnectionController;
import com.bankapp.dao.CustomerDao;
import com.bankapp.user.Customer;

public class CustomerDaoImplementation implements CustomerDao {
	public static ConnectionController cc = ConnectionController.getInstance();
	
	@Override
	public void addCustomer(Customer c) throws SQLException {
		Connection connection = cc.getConnection();
		String sql = "{ call ADDCUSTOMER(?)";
		
		CallableStatement call = connection.prepareCall(sql);
		call.setObject(1, c);
		call.execute();
	}

	@Override
	public Customer getCustomer(int id) throws SQLException {
		Connection connection = cc.getConnection();
		String sql = "{ call GETCUSTOMER(?)";
		
		return null;
	}

	@Override
	public void updateCustomer(Customer c) throws SQLException {
		Connection connection = cc.getConnection();
		String sql = "{ call UPDATECUSTOMER(?)";
	}

	@Override
	public void deleteCustomer(Customer c) throws SQLException {
		Connection connection = cc.getConnection();
		String sql = "{ call DELETECUSTOMER(?)";
	}
}

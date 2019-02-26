package com.bankapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.controllers.ConnectionController;

public class CustomerAccountDaoImp implements CustomerAccountDao {
	private static ConnectionController cc = ConnectionController.getInstance();
	private Connection connection = cc.getConnection();
	
	// Add (customer id, account id) to junction table
	public void addCustomerAccount(int cId, int aId) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO CUSTOMER_ACCOUNT VALUES(" +
			cId + ", " + aId + ")";
		statement.executeUpdate(sql);
	}

	// Delete (customer id, account id) to junction table
	public void deleteCustomerAccount(int cId, int aId) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "DELETE FROM CUSTOMER_ACCOUNT WHERE " +
			"C_ID = " + cId + ", A_ID = " + aId;
		statement.executeUpdate(sql);
	}
}

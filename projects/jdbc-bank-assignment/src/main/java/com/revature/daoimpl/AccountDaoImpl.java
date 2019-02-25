package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.ConnFactory;
import com.revature.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createAccount(int customerID) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "INSERT INTO ACCOUNT_BANK_APP VALUES (ACCOUNT_ID.NEXTVAL, ?, 0)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, customerID);
		ps.executeUpdate();
	}	
}

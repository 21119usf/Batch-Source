package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.ConnFactory;
import com.revature.beans.Customer;
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

	@Override
	public List<Account> getAccountList() throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT_BANK_APP");
		Account a = null;
		while (rs.next()) {
			a = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			accountList.add(a);
		}
		
		return accountList;
	}	
}

package com.revature.bankApplication.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.bankApplication.beans.Account;
import com.revature.bankApplication.dao.AccountDataAccessObject;
import com.revature.bankApplication.utils.ConnectorToDatabase;

public class AccountDataAccessObjectImplimentation implements AccountDataAccessObject {

	@Override
	public void createAccount(int customerid, double balance) throws SQLException {
		Connection conn = ConnectorToDatabase.getConnection();

		String sql = "{ CALL INSERTACCOUNT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
        call.setInt(1, customerid);
        call.setDouble(2, balance);
        call.executeUpdate();
		
	}

	@Override
	public List<Account> getAccountList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void depositAccount(int accountNumber, double balance) throws SQLException {
		Connection conn = ConnectorToDatabase.getConnection();

		String sql = "{ CALL DEPOSIT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
        call.setInt(1, accountNumber);
        call.setDouble(2, balance);
        call.executeUpdate();
	}

	@Override
	public void withdrawAccount(int accountNumber, double balance) throws SQLException {
		Connection conn = ConnectorToDatabase.getConnection();

		String sql = "{ CALL WITHDRAW(?,?)";
		CallableStatement call = conn.prepareCall(sql);
        call.setInt(1, accountNumber);
        call.setDouble(2, balance);
        call.executeUpdate();
		
	}

	@Override
	public void getBalance(int accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}

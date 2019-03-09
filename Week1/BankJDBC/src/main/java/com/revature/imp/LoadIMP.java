package com.revature.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.bankapp.Account;
import com.revature.bankapp.Customer;
import com.revature.dao.LoadDAO;
import com.revature.util.ConnFactory;

public class LoadIMP implements LoadDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createAccount(Account a) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call INSERTACCOUNT(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, a.getId());
		if(a.getActive() == true) {
			call.setString(2, "T");
		}if (a.getActive() == false) {
			call.setString(2, "F");
		}
		call.setDouble(3, a.getBalance());
		call.executeQuery();
	}

	@Override
	public void createCustomer(Customer c) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call INSERTCUSTOMER(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, c.getId());
		call.setString(2, c.getUsername());
		call.setString(3, c.getPassword());
		call.setString(4, c.getName());
		call.setString(5, c.getLast());
		call.executeQuery();
	}

	@Override
	public void createAccountHolders(Customer c) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call INSERTACCHOLDER(?,?)";
		for (int i = 0; i<c.getAccounts().size(); i++) {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, c.getId());
			call.setInt(2, c.getAccounts().get(i).getId());
			call.executeQuery();	
		}
	}

	@Override
	public void clearTables() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String accClear = "{call CLEARACCOUNTS()";
		CallableStatement call = conn.prepareCall(accClear);
		call.executeQuery();
		String cusClear = "{call CLEARCUSTOMER()";
		call = conn.prepareCall(cusClear);
		call.executeQuery();
		String accHClear = "{call CLEARACCHOLDERS()";
		call = conn.prepareCall(accHClear);
		call.executeQuery();
	}
}

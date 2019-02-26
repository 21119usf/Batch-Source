package com.revature.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.bankapp.Account;
import com.revature.bankapp.Admin;
import com.revature.bankapp.Customer;
import com.revature.bankapp.Employee;
import com.revature.dao.ReadDAO;
import com.revature.util.ConnFactory;

public class ReadIMP implements ReadDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public ArrayList<Customer> getCustomerList() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKCUSTOMER");
		Customer c = null;
		while (rs.next()) {
			c = new Customer(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(1));
			customerList.add(c);
		}
		return customerList;
	}

	@Override
	public ArrayList<Employee> getEmployeeList() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKEMPLOYEE");
		Employee e = null;
		while (rs.next()) {
			e = new Employee(rs.getString(1),rs.getString(2));
			employeeList.add(e);
		}
		return employeeList;
	}

	@Override
	public ArrayList<Admin> getAdminList() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKADMIN");
		Admin a = null;
		while (rs.next()) {
			a = new Admin(rs.getString(1),rs.getString(2));
			adminList.add(a);
		}
		return adminList;
	}

	@Override
	public ArrayList<Account> getAccountList() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCOUNT");
		Account a = null;
		while (rs.next()) {
			if(rs.getString(2).equals("T")==true) {
				a = new Account(rs.getInt(1),true,rs.getDouble(3));
				accountList.add(a);
			}if(rs.getString(2).equals("F")==true) {
				a = new Account(rs.getInt(1),false,rs.getDouble(3));
				accountList.add(a);
			}
		}
		return accountList;
	}

	@Override
	public void getAccountHolders(ArrayList<Customer> c, ArrayList<Account> a) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCHOLDERS");
		while (rs.next()) {
			for(int i = 0; i<c.size(); i++) {
				if (rs.getInt(1) == c.get(i).getId())
					for(int j = 0; j< a.size(); j++) {
						if (rs.getInt(2) == a.get(j).getId()) {
							c.get(i).addAccounts(a.get(j));
						}
					}
			}
		}
	}
	
}

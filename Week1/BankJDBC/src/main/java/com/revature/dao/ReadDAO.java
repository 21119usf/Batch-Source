package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.bankapp.Account;
import com.revature.bankapp.Admin;
import com.revature.bankapp.Customer;
import com.revature.bankapp.Employee;

public interface ReadDAO {
	public abstract ArrayList<Customer> getCustomerList() throws SQLException;
	public abstract ArrayList<Employee> getEmployeeList() throws SQLException;
	public abstract ArrayList<Admin> getAdminList() throws SQLException;
	public abstract ArrayList<Account> getAccountList() throws SQLException;
	public abstract void getAccountHolders(ArrayList<Customer> c, ArrayList<Account> a) throws SQLException;
}

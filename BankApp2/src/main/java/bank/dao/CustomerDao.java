package bank.dao;

import java.sql.SQLException;
import java.util.List;

import bank.beans.Account;

public interface CustomerDao 
{
	public abstract List<Account> showAccountInfo(int customerID) throws SQLException;
	public abstract void createAccount(double balance, String type, int customerID) throws SQLException;
	public abstract void addCustomer(String fn, String ln, String un, String pw, String address, String ssn, String phoneNum) throws SQLException;
	public abstract void deleteAccount(int aid) throws SQLException;
	public abstract void depsoit(double money, int aid) throws SQLException;
	public abstract void withdraw(double money, int aid) throws SQLException;
}


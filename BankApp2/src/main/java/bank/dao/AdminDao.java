package bank.dao;

import java.sql.SQLException;
import java.util.List;

import bank.beans.Customers;

public interface AdminDao
{
	public abstract List<Customers> getUser(int id) throws SQLException;
	public abstract void addUser(String fn, String ln, String un, String pw, String address, String ssn, String phoneNum) throws SQLException;
	public abstract void deleteUser(int id) throws SQLException;
	
}

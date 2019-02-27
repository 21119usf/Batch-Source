package com.revature.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface UserInterface {

	double deposit(int userID, double amount) throws SQLException;
	
	double withdraw(int userID, double amount) throws SQLException;
	
	public List<Object>viewAccount(int userID) throws SQLException;

	void cancelAccount(int custUserID, int acctID) throws SQLException;
	
	public double viewAccountBalance(int acctID) throws SQLException;
		
}

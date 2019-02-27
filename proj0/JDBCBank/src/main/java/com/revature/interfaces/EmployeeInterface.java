package com.revature.interfaces;

import java.sql.SQLException;
import java.util.List;
import com.revature.implementers.CustomerLookUp;

public interface EmployeeInterface {
	public void viewAllAccountIDs() throws SQLException;
	public double viewAccountBalance(int acctID) throws SQLException;
	void approveAccount(int userID) throws SQLException;
	void denyAccount(int userID) throws SQLException;
}

package com.revature.dao;

import java.sql.SQLException;

public interface AdminDao {
	void viewAccounts() throws SQLException;
	void delete(int cid) throws SQLException;
	double getBalance(int accId) throws SQLException;
	void updatefirstName(String firstName, int cid) throws SQLException;
	void updatelastName(String lastName, int cid) throws SQLException;
	void updateusername(String username, int cid) throws SQLException;
	void updatepassword(String password, int cid) throws SQLException;
}

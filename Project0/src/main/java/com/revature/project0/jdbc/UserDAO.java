package com.revature.project0.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDAO 
{
	void addNewUser(String username, String password, String type) throws SQLException;
	
	void deleteUser(String username) throws SQLException;
	
	ResultSet getAllEmployees() throws SQLException;
	
	ResultSet getAllAdmins() throws SQLException;
	
	void updateUsername(String newUsername, String oldUsername) throws SQLException;
	
	void updatePassword(String newPassword, String username) throws SQLException;
}

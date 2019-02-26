package com.reavature.dao;

import java.sql.SQLException;

import com.reavture.beans.User;
/*
 * Interface that is used to define method signatures for any class that is using the UserAccount DAO.
 */
public interface UserDAO {
	// Used to convert a Java Object to an SQL record for account
	public boolean createUser(User u) throws SQLException;
	// Used to get a JavaObject User created from database values based on username
	public User getUser(String username) throws SQLException, UsernameException;
	// Used to get a JavaObject User created from database values based on user id
	public User getUser(int userId) throws SQLException;
}

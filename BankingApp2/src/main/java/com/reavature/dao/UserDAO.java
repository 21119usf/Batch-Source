package com.reavature.dao;

import java.sql.SQLException;

import com.reavture.beans.User;

public interface UserDAO {
	public boolean createUser(User u) throws SQLException;
	public User getUser(String username) throws SQLException, UsernameException;
	public User getUser(int userId) throws SQLException;
	public boolean editUser(User u);
}

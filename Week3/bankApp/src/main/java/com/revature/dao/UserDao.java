package com.revature.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.bank.User;

public interface UserDao {
	//GET USER
	public abstract User getUser(String name); 
	//CREATE USERS 
	public abstract void createUser(User user) throws SQLException;
	//EDIT USERS 
	public abstract void editUser(User user) throws SQLException;
	//GET ALL USERS 
	public abstract ArrayList<User> getAllUsers() throws SQLException;
	//APPROVE USERS 
	public abstract void approveUser(User user) throws SQLException; 
	//GET USER ID
	public abstract int getUserId(String username, String password) throws SQLException;
	//DELETE USER
	public abstract void deleteUser(int uid) throws SQLException; 
	//GET BALANCE
	public abstract float getBalance(String username) throws SQLException;
	//CREATE ACCOUNT
	public abstract void createAccount(String username, float balance) throws SQLException;
	//SET BALANCE 
	public abstract void setBalance(String username, float amount) throws SQLException; 
	//GET ACCOUNT NUMBER
	public abstract int getAccountNum(String username) throws SQLException; 
	
 }

package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.users.*;


public interface UserDao {
	
	//CRUD
		//this method we need to place an insert method, here we need a name, id would be sequence
		public abstract void createUser(String firstName, String lastName, String userName, String passWord)throws SQLException;
		//
		public abstract List<CustomerUser> getUserList(int uid) throws SQLException;
		public abstract List<CustomerUser> userSearch(String userName, String passWord) throws SQLException;
		public abstract List<CustomerUser> userID() throws SQLException;
		public abstract int getUserId(String userName, String passWord) throws SQLException;
}

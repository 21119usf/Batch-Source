package com.revature.service;

import java.sql.SQLException;

import com.reavture.beans.User;
import com.revature.utilities.DAOUtilities;

public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public User getUser(int userId) {
		User u = new User();
		try {
			u = DAOUtilities.getUserDAO().getUser(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
}

package com.revature.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.reavature.dao.UserDAO;
import com.reavature.dao.UsernameException;
import com.reavture.beans.User;
import com.revature.input.LoginInput;
import com.revature.utilities.DAOUtilities;
import com.revature.utilities.LoggerUtil;
import com.revature.view.CustomerPortalHomeView;
import com.revature.view.HomeView;
import com.revature.view.LoginView;

public class UserEntryService implements CanEnter{

	@Override
	public void register(User u, String password) {
		u.setHash(BCrypt.hashpw(password, BCrypt.gensalt()));
		UserDAO uDAO = DAOUtilities.getUserDAO();
		try {
			uDAO.createUser(u);
			new LoggerUtil().log("New User Registered" + ": " +u.getUsername());
			new HomeView().display();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			e.printStackTrace();
		}
	}

	@Override
	public void login(String username, String password) {
		try {
			User u = DAOUtilities.getUserDAO().getUser(username);
			if (BCrypt.checkpw(password, u.getHash())) {
				new LoggerUtil().log(username + "Logged In");
				new CustomerPortalHomeView(u).display();
			} else {
				new LoggerUtil().log(username + "Failed Login");
				System.out.println("Invalid Login");
				new LoginView().display();
			}
		} catch (SQLException e) {
			System.out.println("Unexcepted Error");
		} catch (UsernameException e) {
			System.out.println("Invalid Login");
			new LoginInput().getInput();
		}
		
	}

}

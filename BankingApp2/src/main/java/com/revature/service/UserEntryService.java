package com.revature.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.reavature.dao.UserDAO;
import com.reavature.dao.UsernameException;
import com.reavture.beans.User;
import com.revature.utilities.DAOUtilities;
import com.revature.view.CustomerPortalHomeView;
import com.revature.view.LoginView;

public class UserEntryService implements CanEnter{

	@Override
	public void register(User u, String password) {
		u.setHash(BCrypt.hashpw(password, BCrypt.gensalt()));
		UserDAO uDAO = DAOUtilities.getUserDAO();
		try {
			uDAO.createUser(u);
			new CustomerPortalHomeView(u).display();
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
				new CustomerPortalHomeView(u).display();
			} else {
				System.out.println("Invalid Login");
				new LoginView().display();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

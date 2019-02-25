package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.AccountDaoImpl;
import com.revature.views.LoginView;

public class Driver {

	public static void main(String[] args) {
		
		
		try {
			new AccountDaoImpl().createAccount(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new LoginView().login();		
	}
}

package com.revature.driver;


import java.sql.SQLException;

import com.revature.views.WelcomeScreen;

public class BankingAppDriver {

	public static void main(String[] args) throws SQLException {

		WelcomeScreen w = new WelcomeScreen();
		w.introduction();
	}
}

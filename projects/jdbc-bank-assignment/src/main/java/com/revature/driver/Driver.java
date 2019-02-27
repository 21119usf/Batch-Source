package com.revature.driver;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.ApplicationDaoImpl;
import com.revature.utilities.Logging;
import com.revature.views.FrontPageView;

public class Driver {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		new FrontPageView().frontPage();		
	}
}

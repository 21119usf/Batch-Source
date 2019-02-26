package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.views.LoginView;

public class Driver {

	public static void main(String[] args) {
		
		
		try {
//			new AccountDaoImpl().createAccount(1);
//			new CustomerDaoImpl().createCustomer("username", "password", "firstname", "lastname");
//			new ApplicationDaoImpl().createApplication(3);
//			System.out.println(new CustomerDaoImpl().getCustomerListNoPassword());
			System.out.println(new AccountDaoImpl().getAccountList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new LoginView().login();		
	}
}

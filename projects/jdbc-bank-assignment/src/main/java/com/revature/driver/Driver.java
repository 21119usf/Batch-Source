package com.revature.driver;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.revature.daoimpl.AccountDaoImpl;
import com.revature.views.FrontPageView;

public class Driver {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		
		try {
//			new AccountDaoImpl().createAccount(1);
//			new CustomerDaoImpl().createCustomer("username3", "password", "firstname", "lastname");
//			new ApplicationDaoImpl().createApplication(1);
//			System.out.println(new CustomerDaoImpl().getCustomerListNoPassword());
//			System.out.println(new AccountDaoImpl().getAccountList());
//			System.out.println(new ApplicationDaoImpl().getApplicationList());
//			System.out.println(new CustomerDaoImpl().doesCustomerIDExist(10));
//			System.out.println(new CustomerDaoImpl().doesCustomerUsernameExist("a"));
//			System.out.println(new AccountDaoImpl().doesAccountIDExist(100));
//			System.out.println(new ApplicationDaoImpl().doesApplicatoinIDExist(100));
//			System.out.println(new CustomerDaoImpl().login("a", "z"));
//			new CustomerDaoImpl().updateCustomer("gar", "pol", 1);
//			new CustomerDaoImpl().deleteCustomer(6);
//			System.out.println(new CustomerDaoImpl().getCustomerIDFromUsername("a"));
//			System.out.println(new AccountDaoImpl().getAccountListFromCustomerID(1));
			System.out.println(new AccountDaoImpl().doesAccountIDExistAccountIDCustomerID(1, 2));
//			new AccountDaoImpl().setBalanceFromAccountID(1, 100);
//			new AccountDaoImpl().deleteAccountFromAccountID(6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new FrontPageView().frontPage();		
	}
}

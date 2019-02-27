package com.revature.views;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.utilities.Admin;
import com.revature.utilities.ScannerInstance;

public class LoginView {

	public void login() throws SQLException, FileNotFoundException {
		String input;
		Admin a = new Admin();
		
		do {
			String username, password;
			
			System.out.println("Login");
			System.out.println("-----");
			System.out.print("Username: ");
			username = ScannerInstance.scanner.nextLine();
			System.out.print("Password: ");
			password = ScannerInstance.scanner.nextLine();
			
			if (new CustomerDaoImpl().login(username, password)) {
				new CustomerView(username).frontPage();
			} else {
				System.out.println("\nInvalid username/password\n");
			}
			
			System.out.print("Enter \"EXIT\" to exit the login page or enter any other input to continue: ");
			input = ScannerInstance.scanner.nextLine();
			
		} while (!input.equals("EXIT"));
	}
}

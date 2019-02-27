package com.revature.views;

import java.sql.SQLException;

import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.utilities.ScannerInstance;

public class Register {

	public void register() throws SQLException {
		String input;
		
		do {
			String username, password, firstName, lastName;
			
			System.out.print("Enter username: ");
			username = ScannerInstance.scanner.nextLine();
			if (!new CustomerDaoImpl().doesCustomerUsernameExist(username)) {
				System.out.print("Enter password: ");
				password = ScannerInstance.scanner.nextLine();
				System.out.print("Enter first name: ");
				firstName = ScannerInstance.scanner.nextLine();
				System.out.print("Enter last name: ");
				lastName = ScannerInstance.scanner.nextLine();
				new CustomerDaoImpl().createCustomer(username, password, firstName, lastName);
				System.out.println("You just registered a new account!");
			} else {
				System.out.println("Username already exist");
			}
			
			System.out.print("Enter \"EXIT\" to exit the register page or enter any other input to continue: ");
			input = ScannerInstance.scanner.nextLine();
			
		} while (!input.equals("EXIT"));
	}
}

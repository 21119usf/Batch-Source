package com.revature.views;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CustomerDaoImpl;

public class LoginView {

	public void login() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String input;
		
		do {
			String username, password;
			
			System.out.println("Login");
			System.out.println("-----");
			System.out.print("Username: ");
			username = scanner.nextLine();
			System.out.print("Password: ");
			password = scanner.nextLine();
			
			if (new CustomerDaoImpl().login(username, password)) {
//				System.out.println("login");
			} else {
//				System.out.println("\nInvalid username/password\n");
			}
			
			System.out.print("Enter \"EXIT\" to exit the login page: ");
			input = scanner.nextLine();
			System.out.println(input);
			
		} while (!input.equals("EXIT"));
		
		scanner.close();		
	}
}

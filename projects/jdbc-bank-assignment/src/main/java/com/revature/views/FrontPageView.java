package com.revature.views;

import java.sql.SQLException;
import java.util.Scanner;

public class FrontPageView {

	public void frontPage() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String input;
		
		do {
			System.out.println("Bank app");
			System.out.println("--------");
			System.out.println("A. Log in");
			System.out.println("B. Register an account");
			System.out.println("C. Exit program");
			System.out.print("\nSelect an option: ");
			
			input = scanner.nextLine();
			
			if (input.equals("A")) {
				new LoginView().login();
			} else if (input.equals("B")) {
				
			} else if (input.equals("C")) {
				
			} else {
				System.out.println("\nInvalid option\n");
			}
		} while (!input.equals("C"));
		
		scanner.close();
	}
}

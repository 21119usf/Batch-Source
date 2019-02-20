package com.reavature.location;

import java.util.Scanner;

public class Home {
	public void display() {
		System.out.println("Welcome to the Revature Online Banking Portal");
		router();
	}
	
	private void router() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please Enter A Command: ");
		System.out.println("(1) Reigster");
		System.out.println("(2) Login");
		String input = in.nextLine();
		switch(input) {
			case "1":
				new Register().register();
				break;
			case "2":
				new Login().runner();
				break;
			default:
				System.out.println("Invalid Command");
				router();
		}
	}
}

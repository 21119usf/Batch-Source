package com.revature.bap1;

public class CustomerView {
	
	public void initialView(String firstName, String lastName) {
		String header = "Customer: " + firstName + " " + lastName;
		String dashes = "";
		for (int i = 0; i < header.length(); i++) {
			dashes += "-";
		}
		System.out.println(header);
		System.out.println(dashes);
		System.out.println("1. Apply to open a new account");
		System.out.println("2. Apply to join an existing account");
		System.out.println("3. Look at accounts");
		System.out.println("4. Log out");
		System.out.print("\nSelect from one of the following options (1 - 4): ");
	}
	
	public void error() {
		System.out.println("\n***Enter a number between 1 and 4***");
	}
	
	public void applyNewAccount() {
		System.out.println("\nYou have applied for a new account.");
		System.out.println("You have to wait for the new account to be ");
		System.out.println("approved by an employee before you can use it.\n");
	}
}

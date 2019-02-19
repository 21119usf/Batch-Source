package com.revature.bap1;

public class AdminView {
	public void initialView(String firstName, String lastName) {
		String header = "Admin: " + firstName + " " + lastName;
		String dashes = "";
		for (int i = 0; i < header.length(); i++) {
			dashes += "-";
		}
		System.out.println(header);
		System.out.println(dashes);
		System.out.println("1. Approve/Deny open applications");
		System.out.println("2. Withdraw, deposit, or transfer from account to account");
		System.out.println("3. Cancel accounts");
		System.out.println("4. Add Employee");
		System.out.println("5. Add Admin");
		System.out.println("6. Log off");
		System.out.print("\nSelect from one of the following options (1 - 6): ");
	}
	
	public void error() {
		System.out.println("\n***Enter a number between 1 and 6***");
	}
}

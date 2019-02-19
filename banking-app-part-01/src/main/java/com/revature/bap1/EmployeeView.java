package com.revature.bap1;

public class EmployeeView {
	
	public void initialView(String firstName, String lastName) {
		String header = "Employee: " + firstName + " " + lastName;
		String dashes = "";
		for (int i = 0; i < header.length(); i++) {
			dashes += "-";
		}
		System.out.println(header);
		System.out.println(dashes);
		System.out.println("1. Approve/Deny open applications");
		System.out.println("2. View customers information");
		System.out.println("3. Log out");
		System.out.print("\nSelect from one of the following options (1 - 3): ");
	}
	
	public void error() {
		System.out.println("\n***Enter a number between 1 and 3***");
	}
}

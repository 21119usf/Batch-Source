package com.revature.bap1;

public class InitialView {
	
	public void message() {
		System.out.println("Bank app");
		System.out.println("--------");
		System.out.println("1. Log in");
		System.out.println("2. Register an account");
		System.out.println("3. Exit program");
		System.out.print("\nSelect from one of the following options (1 - 3): ");
	}
	
	public void error() {
		System.out.println("\n***Enter a number between 1 and 3***");
	}
}

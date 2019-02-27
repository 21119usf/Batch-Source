package com.revature.utilities;

public class Validation {
	
	public static boolean isLessThanZero(double amount) {
		if (amount < 0) {
			System.out.println("Please enter a positive ammount");
			return true;
		}
		return false;
	}
}

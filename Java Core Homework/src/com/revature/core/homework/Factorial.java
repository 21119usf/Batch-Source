package com.revature.core.homework;

import java.util.Scanner;

// #4
public class Factorial {

	// produce the factorial product of !n
	public static int factorial(int n) {
		// start with 1 so we don't multiply by 0
		int fact = 1;
		// loop backwards from n to i multiplying every i by fact
		for (int i = n; i > 0; i--) {
			fact *= i;
		}
		return fact;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter number to factorial");
		String input = s.nextLine();
		System.out.println(Factorial.factorial(Integer.parseInt(input)));
		s.close();
	}
}

package com.revature.nfactorial;

import java.util.Scanner;

public class nFactorial {

	public static void main(String[] args) {
		System.out.println("Input a number: ");
		Scanner input = new Scanner(System.in);
		int num= input.nextInt();
		System.out.println("The factorial of " + num +" is " + factorial(num));
		
	}


	public static int factorial(int n) {
		if (n==0)
		return 1;
		
		return n*factorial(n-1);
	}
}

package com.revature.q4;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);//prompt for user input
		System.out.println("Input a number: ");
		
		int numberOfFactorial = userInput.nextInt();// userInput.nextInt is expecting an integer
		int factorialCalc = 1;
		
		for( int i = 1; i <= numberOfFactorial; i++) { // factorial calculation part
			
			factorialCalc = factorialCalc * i;
		}
		
		System.out.println("Factorial of " + numberOfFactorial + " is " + factorialCalc);
		
		userInput.close(); // needed to prevent memory leak

	}

}

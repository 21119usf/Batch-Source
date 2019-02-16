package com.revature.core.homework;

// #2
public class Fibonacci {
	
	public static String run(int n) {
		// string of fibonacci numbers
		String numbers = "";
		//the current first Number to be added in the sequence
		int firstNumber = 0;
		// the current second Number to be added in the sequence
		int secondNumber = 1;
		int result = 0;
		// Fibonacci of 0 is 0
		numbers += "0\n";
		/*
		 * loop that set the result based on the current two numbers in sequence
		 * then set the first number in sequence to the second and the second to the current
		 * result
		 */
		for (int i = 1; i < n; i++) {
			result = firstNumber + secondNumber;
			numbers += result + "\n";
			firstNumber = secondNumber;
			secondNumber = result;
		}
		return numbers;
	}

	public static void main(String[] args) {
		System.out.println(Fibonacci.run(5));
	}
}

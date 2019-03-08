package com.revature.question10;

import java.util.Scanner;

public class Question10 {

	// Find the minimum of two numbers using ternary operators.
	
	static Scanner input = new Scanner(System.in);
	static int result;
	static int number1;
	static int number2;
	
	public static void minimum(int a, int b) {
		result = a > b
				? b
				: a;
		System.out.println(result + " is smaller.");
	}
	
	public static void main(String[] args) {
		System.out.println("Enter first value: ");
		number1 = input.nextInt();
		
		System.out.println("Enter second value: ");
		number2 = input.nextInt();
		minimum(number1, number2);
	}
	
}

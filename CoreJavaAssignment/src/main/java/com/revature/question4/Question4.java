package com.revature.question4;

import java.util.Scanner;

public class Question4 {

	//Write a program to compute N factorial.
		static Scanner input = new Scanner(System.in);
		static int number;
		static int total = 1;
		
		public static void factorial(int a) {
			for(int i = 1; i <= a; i++) {
				total = total * i;
			}
		}
		
		public static void main(String[] args) {
			System.out.println("Enter value to find factorial: ");
			number = input.nextInt();
			factorial(number);
			System.out.println("The factorial of " + number + " is " + total);
		}
}

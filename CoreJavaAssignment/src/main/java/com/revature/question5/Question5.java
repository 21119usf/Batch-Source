package com.revature.question5;

import java.util.Scanner;

public class Question5 {

		//Write a substring method that accepts a string str and an integer idx 
		//and returns the substring contained between 0 and idx-1 inclusive. 
		//
		//Do NOT use any of the existing substring methods in the String, 
		//StringBuilder, or StringBuffer APIs.
		

		static Scanner input = new Scanner(System.in);
		static String user;
		static int number;
		
		public static void returner(String a, int b) {
			
			System.out.println("The string contained between 0 and idx-1 of \"" 
					+ a + "\" is \"");
			for(int i = 0; i < b; i++) {
				System.out.print(a.charAt(i));
			}
			System.out.println("\".");
		}
		
		public static void main(String[] args) {
			System.out.println("Enter string: ");
			user = input.next();

			System.out.println("Enter number: ");
			number = input.nextInt();
			
			returner(user, number);
			
		}
}

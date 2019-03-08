package com.revature.question3;

import java.util.Scanner;

public class Question3 {
	//Reverse a string without using a temporary variable.  
	//DO NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	
	static Scanner input = new Scanner(System.in);
	public static String user = "";
	
	public static void reverse(String a) {

		final int value = user.length();
		char[] array = new char[value];
		
		for(int i = value; i > 0 ; i--) {
			 array[value - i] = user.charAt(i-1);
		}
		for(int i = 0; i < value; i++) {
			System.out.print(array[i]);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter string: ");
		user = input.next();
		
		reverse(user);
	}
}

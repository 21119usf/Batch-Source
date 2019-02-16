package com.revature.example;

import java.util.Scanner;

public class CustomExceptionExample {

	public static void CheckIfUppercase(String s) throws NotUppercaseException{
		String original = s;
		s = s.toUpperCase();
		if (!(original.equals(s))) {
			throw new NotUppercaseException();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This program will take in a string and check to see if" +
							" the entire string is UPPERCASE\nThrows an error otherwise");
		Scanner input = new Scanner(System.in);
		System.out.print("\n\nPlease input a string to check\n> ");
		String string = input.nextLine();
	
		try {
			CheckIfUppercase(string);
			System.out.println("Good Job");
		}
		catch(NotUppercaseException e) {
			e.printStackTrace();
		}
	}
}
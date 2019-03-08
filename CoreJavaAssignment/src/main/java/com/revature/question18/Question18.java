package com.revature.question18;

import java.util.Scanner;

public class Question18 extends SuperClass{

	/*
	 * Write a program having a concrete subclass that inherits 
	 * three abstract methods from a superclass.  
	 * Provide the following three implementations in the subclass 
	 * corresponding to the abstract methods in the superclass:
 
1. Check for uppercase characters in a string, 
and return ‘true’ or ‘false’ depending if any are found.

2. Convert all of the lower case characters to uppercase 
in the input string, and return the result.

3. Convert the input string to integer and add 10, 
output the result to the console.

Create an appropriate class having a main method to test the above setup.
	 */
	
	
	static Scanner input = new Scanner(System.in);
	public Question18() {
		super();
		// TODO Auto-generated constructor stub
	}

	static String str = "";
	
	public static void main(String[] args) {
		System.out.println("Enter String: ");
		str = input.nextLine();
		Question18 driver = new Question18();
		driver.check(str);
		driver.uppercase(str);
		driver.convert(str);
		
		
	}

	@Override
	public void check(String a) {
		// TODO Auto-generated method stub
		boolean up = false;
		for (int i = 0; i < a.length(); i ++) {
			if(Character.isUpperCase(a.charAt(i)) == true) {
				up = true;
				System.out.println(up + ": Uppercase characters contained in String");
				break;
			}
		}
		if(up == false) {
			System.out.println(up + ": Uppercase characters not contained in String");	
		}
	
	}

	@Override
	public void uppercase(String b) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.print("All uppercase string: ");
		char[] placeholder = new char[b.length()];
		for (int i = 0; i < b.length(); i ++) {
			if(Character.isUpperCase(b.charAt(i)) == true) {
				placeholder[i] = b.charAt(i);
				continue;
			}
			else {
				placeholder[i] = Character.toUpperCase(b.charAt(i));
			}
		}
		System.out.println(placeholder);
		System.out.println();
	}

	@Override
	public void convert(String c) {
		int number = 0;
		
		try {
			number = Integer.parseInt(c);
		}
		catch(NumberFormatException e) {
			System.out.println("Value of String: " + number);
		}
	}

}

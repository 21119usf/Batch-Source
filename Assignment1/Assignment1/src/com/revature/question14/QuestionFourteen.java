package com.revature.question14;

import java.util.Date;
import java.util.Scanner;

public class QuestionFourteen {
//Q14. 
//	Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
//	Case 1: Find the square root of a number using the Math class method.
//	Case 2: Display today’s date.
//	Case 3: Split the following string and store it in a string array.
//	       	 “I am learning Core Java”

	//switch method that does the actual switching
	public static void switchMethod(int cases) {
	switch (cases) {
	case 1 : 
		//case 1, taking the square root using the Math class method
		System.out.println("Which number would you like to take the square root of?");
		//allowing user to choose the number
		Scanner input = new Scanner(System.in);
		double num = input.nextDouble();
		double root = Math.sqrt(num);
		System.out.println("The square root of " + num + " is: "+ root);
		break;
		//case 2, printing today's date using the Date class method
	case 2 :
		Date date = new Date();
		System.out.println("Today's date is: " + date.toString());
		break;
		//case 3, splitting a String into a String array
	case 3 :
		//giving the user the option of storing their own string
		System.out.println("Would you like to store the default String or your own message?\n"
				+ "1 - Store \"I am learning Core Java\"\n"
				+ "2 - Store your own message");
		Scanner input3 = new Scanner(System.in);
		int choice = input3.nextInt();
		//if they chose their own option
		if (choice == 2) {
			System.out.println("What would you like your message to be?");
			Scanner input32 = new Scanner(System.in);
			String full = input32.nextLine();
			//using a separate stringStore method to do the storing to save code length
			stringStore(full);
		}
		//the prompt tells user to input 1, but anything but 2 will output the default required for this assignment
		else {
			String full = "I am learning Core Java";
			stringStore(full);
			}
		}
	}
	//stringStore method
	public static void stringStore(String full){
		//splitting the string based on the separation by spaces
		String [] splitString = full.split(" ");
		int length = splitString.length;
		//putting quotations around the full output and the separated output
		System.out.println("\"" + full + "\" has been split into ");
		for (int i = 0; i < length; i++) {
		System.out.print("\"" + splitString[i] + "\" ");
	}

		System.out.println("and saved as an array.");
	}
	//main method that initiates the switch method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to do?\n"
				+ "1 - Find the square root of a number\n"
				+ "2 - Find today's date\n"
				+ "3 - Split a string into an array");
		int cases = input.nextInt();
		//initiating the previously seen switchMethod method
		switchMethod(cases);
	}

}


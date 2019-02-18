package com.revature.hw1;

import java.time.LocalDateTime;

public class Prob14SwitchCase {

	
	
	
	static int n;
	public static void switchCases(int n) {
		switch (n) {
		case 1:
			//Find the square root of a number using the Math class method.
			double sqrt4 = Math.sqrt(4);
			System.out.println("The square root of 4 is " + sqrt4 + ".");

			break;
		case 2:
			//Display today’s date.
			System.out.printf("Todays Date and Time: %s%n", LocalDateTime.now());
			break;
		case 3:
			//Split the following string and store it in a string array.
	       	// “I am learning Core Java”
			String str = "I am learning Core Java"; 
			String [] arrOfStr = str.split(" "); 
			for(String a:arrOfStr) 
			System.out.println(a);
			break;
		default:
			System.out.println("I am learning Core Java");
		}}
		
		
		
	public static void main(String[] args) {
		switchCases(3);
		

	}

}

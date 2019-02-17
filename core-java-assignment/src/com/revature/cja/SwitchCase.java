// Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
// Case 1: Find the square root of a number using the Math class method.
// Case 2: Display today’s date.
// Case 3: Split the following string and store it in a string array. “I am learning Core Java”

package com.revature.cja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SwitchCase {
	
	private String msg = "I am learning Core Java";
	// the split string
	private String[] splitString;
	
	// method to run the different switch cases
	public void switchCase(int caseNum) {
		int sqRoot = 16;
		
		switch (caseNum) {
		case 1:
			System.out.println("Square root of " + sqRoot + " is " + Math.sqrt(sqRoot));
			break;
		case 2:
			LocalDate localDate = LocalDate.now();
			System.out.println("Today's date is " + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(localDate));
			break;		
		case 3:
			splitString = msg.split(" ");
			for (int i = 0; i < splitString.length; i++) {
				System.out.print(splitString[i]);
				System.out.println();
			}
			break;
		default:
			
			break;
		}
	}
}

// Q6. Write a program to determine if an integer is even without using the modulus operator (%)

package com.revature.cja;

public class IsIntegerEven {
	
	// method that checks if number is even or odd
	public String isEven(int num) {
		boolean isEven = true;
		for (int i = 1; i <= num; i++) {
			isEven = !isEven;
		}
		
		if (isEven) {
			return "Even";
		} else {
			return "Odd";
		}
	}

}

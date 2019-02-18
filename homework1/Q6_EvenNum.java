package com.revature.homework1;
import java.util.Scanner;
import java.math.*;

public class Q6_EvenNum {
	
	// Even Number Method
	public static void evenNumber(double x) {
		//Test that x is even
		if(x/2> Math.floor(x/2)){
			System.out.println("Number is Odd!");	// print odd
		}else {
			System.out.println("Number is Even!");	// print even
		}
	}
	
	// check user input for integer values only
	public static int userInput() {
		System.out.println("Enter an integer:");
		Scanner someScanner = new Scanner(System.in);
		// attempted to assign user input as an integer
		try {
			int k = someScanner.nextInt();
			someScanner.close();	// close the scanner
			return k;				// return the integer to be checked
		}catch (Exception e) {		// for when x is not an integer
			System.out.println("That is not an integer.");
		}
		return 0;					// continue until we get an integer
	}
		
	
	public static void main(String[] args) {
		int z = 0;
		while(z==0) {
			z = userInput();		// assign user input to test
		}	
		evenNumber(z);				// test the user input
	}

}
	

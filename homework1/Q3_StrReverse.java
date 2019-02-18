package com.revature.homework1;
import java.util.Scanner;

public class Q3_StrReverse {

	// Reverse String Method
	public static String stringReverse(String s) {
		// Create an empty Mutable String
		StringBuilder sr = new StringBuilder("");
		// Fill the string starting at the end of the argument String
		for(int i=s.length()-1; i>=0; i--) {
			sr.append(s.charAt(i));				// add to the stringBuilder
		}
		return sr.toString();					// return stringBuilder as a string
	}
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter a string to reverse: ");
		String s = myScanner.nextLine();
		myScanner.close();
		String reversedString = stringReverse(s);
		System.out.println("Your string was: " + s + "\nYour reversed string is: " + reversedString);
	}

}

package com.revature.homework1;

public class Substring {
	
	/*
	 * we take in a string and an int from the user. then we turn the string into a character array
	 * once we have that we establish a new string and iterate through the character array for the amount
	 * of times the user specified and save each character at the indexes to a new string and print
	 */

public static void subStringIt(String str, int idx) {
	char[] theString = new char[str.length()];
	for(int i = 0; i < str.length(); i++) {
		theString[i] = str.charAt(i);
	}
	String s =  "";
	for(int a = 0; a <= idx; a++) {
		s+= theString[a];
	}
	System.out.println(s);
}

public static void main(String[] args) {
	subStringIt("five", 2);
}

}

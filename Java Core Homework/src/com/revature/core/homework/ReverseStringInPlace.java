package com.revature.core.homework;

// #3
public class ReverseStringInPlace {
	public static String doIt(String str) {
		for (int i = 0; i < str.length(); i++) {
			// remove head and previously reversed chars
			str = str.substring(1, str.length() - i)
			// add new head to back of string
			+ str.substring(0, 1)
			// add rest of sorted chars to end of string
			+ str.substring(str.length() - i, str.length());
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(ReverseStringInPlace.doIt("red"));
	}
}



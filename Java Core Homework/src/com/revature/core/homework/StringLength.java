package com.revature.core.homework;

public class StringLength {

	// #16
	public static void main(String[] args) {
		int length = getLength(args);
		System.out.println("Number of charecters provided: " + length);
	}
	
	public static int getLength(String[] args) {
		int length = 0;
		for (String x : args) {
			length += x.length();
		}
		return length;
	}

}

package com.revature.corejava;

// Class to determine if an integer is even
public class Q06 {
	// Determine if integer is even
	public static boolean isEven(int n) {
		if (n == n/2 * 2) {
			return true;
		}
		
		return false;
	}
	
	// Main
	public static void main(String[] args) {
		System.out.println(isEven(101));
		System.out.println(isEven(10));
	}
}

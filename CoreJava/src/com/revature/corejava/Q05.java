package com.revature.corejava;

// Class to return a substring
public class Q05 {
	// Return substring
	public static String substring(String str, int idx) {
		// Check bounds
		if (str.length() <= idx) {
			return "ERROR:  Out of bounds";
		}
		
		// Create substring
		String result = "";
		for (int i=0; i<=idx; i++) {
			result += str.charAt(i);
		}
		
		return result;
	}
	
	// Main
	public static void main(String[] args) {
		String str = "This is a string";
		int idx = 10;
		
		System.out.println(substring(str, idx));
	}
}

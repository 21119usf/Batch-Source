package com.revature.utilities;

public class ParseString {

	public static double parseD(String str) {
		double num;
		
		try {
			num = Double.parseDouble(str);
			return num;
		} catch (NumberFormatException e) {
			System.out.println("Please enter a double");
		}
		
		return Double.NEGATIVE_INFINITY;
	}
	
	public static int parseI(String str) {
		int num;
		
		try {
			num = Integer.parseInt(str);
			return num;
		} catch (NumberFormatException e) {
			System.out.println("Please enter an integer");			
		}
		
		return Integer.MIN_VALUE;
	}
}

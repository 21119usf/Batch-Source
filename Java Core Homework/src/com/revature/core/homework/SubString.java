package com.revature.core.homework;

// #5
public class SubString {

	public static String subString(String str, int indexCap) {
		String result = "";
		
		for (int i = 0 ; i < indexCap; i++) {
			result += str.charAt(i);
		}
		return result;
	}
}

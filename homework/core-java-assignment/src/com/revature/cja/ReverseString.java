//Q3. Reverse a string without using a temporary variable. Do NOT use reverse() in the
//StringBuffer or the StringBuilder APIs.

package com.revature.cja;

public class ReverseString {
	
	// method to reverse a string
	public String reverseString(String str) {
		
		for (int i = str.length() - 1; i >= 0; i--) {
			str += str.charAt(i);
		}
		
		return str.substring(str.length() / 2, str.length());
	}
}

//Q5. Write a substring method that accepts a string str and an integer idx and returns the
//substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
//substring methods in the String, StringBuilder, or StringBuffer APIs.

package com.revature.cja;

public class SubstringClass {
	
	// method to compute a substring
	public String substring(String originalStr, int idx) {
		String str = "";
		
		for (int i = 0; i < idx; i++) {
			str += originalStr.charAt(i);
		}
		
		return str;
	}

}

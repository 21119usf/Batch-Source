package com.revature.cja;

public class SubstringClass {
	
	public String substring(String originalStr, int idx) {
		String str = "";
		
		for (int i = 0; i < idx; i++) {
			str += originalStr.charAt(i);
		}
		
		return str;
	}

}

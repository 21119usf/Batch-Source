package com.revature.homework;

public class Q18sub extends Q18{

	@Override
	boolean CheckUpper(String s) {
		// TODO Auto-generated method stub
		char x;
		for (int i = 0; i < s.length(); i++) {
			x = s.charAt(i);
			if(Character.isUpperCase(x) == true) {
				return true;
			}
		}		return false;
	}

	@Override
	String ConvLower(String s) {
		// TODO Auto-generated method stub
		char x;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			x = s.charAt(i);
			if(Character.isLowerCase(x) == true) {
				result = result + Character.toUpperCase(x);
			} else {
				result = result + x;
			}
		}		return result;
	}

	@Override
	public int StrInt(String s) {
		// TODO Auto-generated method stub
		int result = Integer.parseInt(s);
		result = result + 10;
		return result;
	}
	
}

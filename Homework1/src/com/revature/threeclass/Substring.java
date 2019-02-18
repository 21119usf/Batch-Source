package com.revature.threeclass;

public class Substring extends Super{

	@Override
	boolean containsUpper(String str) {
		// TODO Auto-generated method stub
		for(int i=0; i<=str.length(); i++) {
			Character c = str.charAt(i);
			if(Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	String changeUpper(String str) {
		// TODO Auto-generated method stub
		return str.toUpperCase();
	}

	@Override
	int addString(String str) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = Integer.parseInt(str);
		}catch(NumberFormatException e) {
			i = 0;
		}
		i += 10;
		return i;
	}
	

}

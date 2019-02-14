package com.revature.corejava;

public class Q18Sub extends Q18Super {
	@Override
	boolean containsUppers(String str) {
		for (int i=0; i<str.length(); i++) {
			Character c = str.charAt(i);
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	String convertToUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	int strToIntPlusTen(String str) {
		int i = 0;
		
		// Cannot always convert Strings to ints
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			i = 0;
		}
		
		i += 10;
		return i;
	}
}

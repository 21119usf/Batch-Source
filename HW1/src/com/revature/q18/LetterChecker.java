package com.revature.q18;

public class LetterChecker extends ActualCheck {
	
	//original method, cant do nothing
	void notChecking(String str) {
		System.out.println("uh.. Nope!");
	}

	
	//methods from the abstract class
	@Override
	boolean checkUpper(String string) {
		boolean hasUppercase = !string.equals(string.toLowerCase());
		if(hasUppercase) {
			return true;
		}
		return false;
	}

	@Override
	String toupper(String string) {
		return string.toUpperCase();
	}

	@Override
	int stringPlusTen(String string) {
		int stringlength = string.length();
		return stringlength + 10;
	}

}

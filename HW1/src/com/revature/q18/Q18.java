package com.revature.q18;

public class Q18 {

	public static void main(String[] args) {
		
		LetterChecker check = new LetterChecker();
		
		String theString = "frank";
		String theString2 = "fraNk";
		
		check.notChecking(theString);
		
		//Checking captials in a string. 
		System.out.println("True/False: " + theString + " has a Capital in it. " + check.checkUpper(theString)); //case no caps
		System.out.println("True/False: " + theString2 + " has a Capital in it. " + check.checkUpper(theString2)); //case with 1 cap
		
		// makes a lowercase  string to all capitals
		System.out.println("Original: " + theString + " viola! " + check.toupper(theString));
		
		//adding length of string + 10 
		System.out.println("length of the string: " + theString.length() + " and now level up by 10! bam! " + check.stringPlusTen(theString));
	}

}

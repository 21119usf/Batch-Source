package com.revature.homework1;

public class Reverse {
	
	
		/*
		 * we take a string as input and establish an empty string
		 * we then loop through the input string starting at the last index and add each element 
		 * to a new string variable and then print it
		 * 
		 */
	public static String reverseString(String inString) {
		String reversedString = "";
		for(int i = inString.length()-1; i >= 0; i--) {
			reversedString += inString.charAt(i);
		}
		return reversedString;
		
	}
	    public static void main(String[] args) {
	    	
	        System.out.println(Reverse.reverseString("cat"));
	    
	    
	    }

	


}



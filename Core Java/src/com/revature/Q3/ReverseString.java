package com.revature.Q3;

public class ReverseString {
	
		public static void main(String[] args) {
			String stringToReverse = "wahoooo I'm a string";				//Create string to be reversed
			System.out.println("String to be reversed: "+stringToReverse);
			String reversedString = reverseString(stringToReverse);			//Reverse string and save
			System.out.println("Reversed String: "+reversedString);	
		}
		
		/*reverseString
		 * Input		: String
		 * Output		: String
		 * Alog			: Recursively call this function on a string
		 * 				  with the first character removed until there 
		 * 				  is only one character left and return that character
		 * 				  All previous characters will be concatenated in 
		 * 				  reverse order.
		 */
		
		public static String reverseString(String stringToReverse) {
			if(stringToReverse.length() == 1)return stringToReverse;
			return  reverseString(stringToReverse.substring(1)) + stringToReverse.charAt(0);
		}
}

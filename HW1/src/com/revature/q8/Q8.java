package com.revature.q8;

import java.util.ArrayList;

public class Q8 {
	
	public static void main(String[] args) {
	
		//array of string “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		
		String[] myStringArray = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> palindromes = new ArrayList<String>();
		
		
		
		System.out.println("all words");
		
		for( String i : myStringArray) {
			System.out.print(i + " ");
			
			//check for palindrom if true save it in new array
			if(checkPalindrome(i)) {
				palindromes.add(i);//adding words to the array named palindromes by looping current array
			}
		}
		
		System.out.println("\n\nPalindomes words");
		
		for( String i : palindromes) {
			System.out.print(i + " ");
		}
	}
	
	/*
	 * if the word equals its reversed self 
	 * then send true back
	 * if it doesnt it will send false
	 * 
	 */
	private static boolean checkPalindrome(String palindrome) {
		
		return palindrome.equals(new StringBuilder(palindrome).reverse().toString());
	}
}

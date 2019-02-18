package com.revature.core.java.assignment;

import java.util.ArrayList;

public class PalindromSeperator 
{
	/*
	 * Takes in an arraylist and returns a new arraylist containing just the palandromes.
	 */
	public ArrayList<String> seperatePalindromes(ArrayList<String> list)
	{
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String word : list)
		{
			if(isPalendrome(word))
			{
				palindromes.add(word);
			}
		}
		
		return palindromes;
	}
	
	/*
	 * Determines if a String is a palindrome.
	 */
	private static boolean isPalendrome(String word)
	{
		boolean palendrome = false;
		
		StringReverser stringReverser = new StringReverser();
		
		if(word.equals(stringReverser.reverseString(word)))
		{
			palendrome = true;
		}
		
		return palendrome;
	}
}

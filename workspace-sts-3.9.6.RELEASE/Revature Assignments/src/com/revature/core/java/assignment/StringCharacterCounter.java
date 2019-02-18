package com.revature.core.java.assignment;

public class StringCharacterCounter 
{
	/*
	 * Counts the number of characters in a given String.
	 */
	public int countCharacters(String string)
	{
		int counter = 0;
		for(String s : string.split(""))
		{
			counter++;
		}
		
		return counter;
	}
}

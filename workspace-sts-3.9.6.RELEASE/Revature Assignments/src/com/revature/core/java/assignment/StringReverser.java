package com.revature.core.java.assignment;

public class StringReverser 
{
	/*
	 * Reverses the order of the string.
	 */
	public String reverseString(String string)
	{
		for(int i = (string.length() - 1); i >= 0; i--)
		{
			string += string.charAt(i);
		}
		
		return string.substring((string.length() / 2), string.length());
	}
}

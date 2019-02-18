package com.revature.core.java.assignment;

public class Substring 
{
	/*
	 * Returns a substring of a given string using a given index. The substring will contain
	 * characters from index 0 to the given index.
	 */
	public String getSubstring(String string, int index)
	{
		String substring = "";
		for(int i = 0; i < index; i++)
		{
			substring += string.charAt(i);
		}
		
		return substring;
	}

}

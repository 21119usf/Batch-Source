package com.revature.core.java.assignment;

public class StringChecker extends StringChecks
{
	/*
	 * Checks if a string contains an uppercase letter.
	 */
	@Override
	public boolean checkForUppercase(String string)
	{
		boolean foundUppercase = false;
		for(int i = 0; i < string.length(); i++)
		{
			if(Character.isUpperCase(string.charAt(i)))
			{
				foundUppercase = true;
				break;
			}
		}
		
		return foundUppercase;
	}
	
	/*
	 * Converts a string to all uppercase.
	 */
	@Override
	public String convertToUppercase(String string)
	{
		return string.toUpperCase();
	}
	
	@Override
	public int convertStringToInt(String string)
	{
		int newInt;
		try 
		{
			newInt = Integer.parseInt(string);
		}
		catch (NumberFormatException e)
		{
			System.out.println("That is not a number.");
			newInt = 0;
		}
		
		return newInt;
	}
}

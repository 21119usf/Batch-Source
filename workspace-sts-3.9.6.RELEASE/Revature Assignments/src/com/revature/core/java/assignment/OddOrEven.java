package com.revature.core.java.assignment;

public class OddOrEven 
{
	/*
	 * Determines whether a number is odd or even.
	 */
	public String determineOddOrEven(int number)
	{
		boolean isEven = true;
		for(int i = 0; i < number; i++)
		{
			if(isEven)
			{
				isEven = false;
			}
			else
			{
				isEven = true;
			}
		}
		
		String oddOrEven = "";
		
		if(isEven)
		{
			oddOrEven = "Even";
		}
		else 
		{
			oddOrEven = "Odd";
		}
		
		return oddOrEven;
	}
}

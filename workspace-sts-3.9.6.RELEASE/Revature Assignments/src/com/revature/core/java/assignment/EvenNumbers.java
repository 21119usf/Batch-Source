package com.revature.core.java.assignment;

import java.util.ArrayList;

public class EvenNumbers 
{
	/*
	 * Takes in an array and returns an array containing just the even numbers.
	 */
	public ArrayList<Integer> findEvenNumbers(ArrayList<Integer> numbers)
	{
		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		
		for(int number : numbers)
		{
			if(isEvenNumber(number))
			{
				evenNumbers.add(number);
			}
		}
		
		return evenNumbers;
	}
	
	/*
	 * Determines whether a number is even.
	 */
	private static boolean isEvenNumber(int number)
	{
		boolean isEven = false;
		for(int i = 0; i <= number; i++)
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
		
		return isEven;
	}
}

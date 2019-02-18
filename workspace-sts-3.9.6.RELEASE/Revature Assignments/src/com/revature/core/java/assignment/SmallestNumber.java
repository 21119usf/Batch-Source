package com.revature.core.java.assignment;

public class SmallestNumber 
{
	/*
	 * Determines which of two numbers is the smallest.
	 */
	public int findSmallestNumber(int a, int b)
	{
		int smallestNumber = a < b ? a : b;
		
		return smallestNumber;
	}
}

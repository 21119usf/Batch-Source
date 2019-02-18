package com.revature.core.java.assignment;

public class Factorial 
{
	/*
	 * Computes the factorial of a number n.
	 */
	public int computeFactorial(int n)
	{
		int factorial = 1;
		for(int i = n; i > 0; i--)
		{
			factorial *= i;
		}
		
		return factorial;
	}
}

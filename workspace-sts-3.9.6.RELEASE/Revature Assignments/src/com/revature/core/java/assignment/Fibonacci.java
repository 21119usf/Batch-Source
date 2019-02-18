package com.revature.core.java.assignment;

public class Fibonacci 
{
	/*
	 * Displays the fibonacci sequence of length n.
	 */
	public void displayFibonacciSequence(int n)
	{
		int previous = 0;
		int current = 1;
		for(int i = 0; i < n; i++)
		{
			if(i <= 1)
			{
				System.out.println(i);
			}
			else
			{
				int temp = previous + current;
				System.out.println(temp);
				previous = current;
				current = temp;
			}
		}
	}

}

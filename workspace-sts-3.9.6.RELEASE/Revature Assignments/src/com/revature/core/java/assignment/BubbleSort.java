package com.revature.core.java.assignment;

public class BubbleSort 
{
	/*
	 * Swaps two numbers in an integer array.
	 */
	private static void swap(int a, int[] x)
	{
		int temp = x[a];
		x[a] = x[a + 1];
		x[a + 1] = temp;
	}
	
	/*
	 * Determines if an integer array has been completely sorted.
	 */
	private static boolean isSorted(int[] x)
	{
		boolean sorted = true;
		int temp = x[x.length - 1];
		for(int i = 0; i < (x.length - 1); i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(x[j] > x[i])
				{
					sorted = false;
				}
			}
		}
		
		return sorted;
	}
	
	/*
	 * Performs bubble sort on an integer array.
	 */
	public void sort(int[] x)
	{
		boolean sorted = false;
		while(sorted == false)
		{
			for(int i = 0; i < (x.length - 1); i++)
			{
				if(x[i] > x[i + 1])
				{
					swap(i, x);
				}
			}
			
			sorted = isSorted(x);
		}
	}
}

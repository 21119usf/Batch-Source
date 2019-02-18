package com.revature.core.java.assignment;

import java.util.ArrayList;

public class ArrayListActions 
{
	private ArrayList<Integer> list;
	
	//This is the constructor for this class. It takes in an int and constructs an array of that size.
	public ArrayListActions(int size)
	{
		list = new ArrayList<Integer>();
		
		for(int i = 1; i <= size; i++)
		{
			list.add(i);
		}
	}
	
	/*
	 * Prints the contents of the arraylist maintained by this class.
	 */
	public void displayArrayList()
	{
		for(Integer i : this.list)
		{
			System.out.println(i);
		}
	}
	
	/*
	 * Adds all odd numbers in the array and display's them.
	 */
	public void addAllOdds()
	{
		int oddSum = 0;
		OddOrEven oddOrEven = new OddOrEven();
		for(Integer i : this.list)
		{
			if(oddOrEven.determineOddOrEven(i) == "Odd")
			{
				oddSum += i;
			}
		}
		
		System.out.println("Sum of the odds is " + oddSum);
	}
	
	/*
	 * Removes the prime numbers from the arraylist and then calls displayArrayList().
	 */
	public void removePrimes()
	{	
		PrimeNumberFinder finder = new PrimeNumberFinder();
		
		int x = 0;
		while(x < list.size())
		{
			if (finder.isPrime(this.list.get(x)))
			{
				list.remove(x);
				continue;
			}
			x++;
		}
		
		this.displayArrayList();
	}
}

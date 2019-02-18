package com.revature.core.java.assignment;

import java.util.ArrayList;

public class PrimeNumberFinder 
{
	/*
	 * Takes in an arraylist and returns a new arraylist with just the prime numbers.
	 */
	public ArrayList<Integer> findPrimeNumbers(ArrayList<Integer> numbers)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(Integer number : numbers)
		{
			if(isPrime(number))
			{
				primes.add(number);
			}
		}
		
		return primes;
	}
	
	/*
	 * Determines if a given number is a prime.
	 */
	public static boolean isPrime(int number)
	{
		boolean prime = true;
		if(number <= 1)
		{
			prime = false;
		}
		for(int i = 2; i < number; i++)
		{
			if((number % i) == 0)
			{
				prime = false;
				break;
			}
		}
		
		return prime;
	}
}

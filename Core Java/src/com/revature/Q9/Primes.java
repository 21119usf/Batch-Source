package com.revature.Q9;

import java.util.ArrayList;

public class Primes {
	/*
	 * In order to print all primes from 1 to 100 I
	 * decided to use the Sieve of Eratosthenes for it's efficiency.
	 * Basically instead of testing each value for primeness we eliminate
	 * all values we know aren't prime.
	 */
	
	
	/* The sieve is a boolean array.
	 * An index is considered prime until proven otherwise
	 * sieve[i] = false if i is prime and vice versa
	 * This is counter intuitive however easier than
	 * Initializing the entire array to true
	 */
	static boolean[] sieve = new boolean[101];
	
	public static void main(String[] args) {
		findPrimes();
		printPrimes();		
	}
	/*findPrimes
	 * Input	: none
	 * Output	: void
	 * Algo		: 0 & 1 are set to true(not prime) immediately since this algorithm
	 * 			  won't loop through them/work without them being set to not prime.
	 *			  We loop starting at 2 (the first prime) until 10 since all numbers 
	 *			  between 1 and n must have a factor less than sqrt(100). If the current 
	 *			  number is prime then we eliminate all multiples of that number
	 *  		  in the space, everything left must be prime. Creates arraylist of pimes
	 *  		  and returns it for Junit testing purposes
	 */
	public static ArrayList<Integer> findPrimes() {
		sieve[0] = true;
		sieve[1] = true;
		for(int i=2; i <= 10; i++) {			
			if(!sieve[i]) {
				for(int j = i*i; j <= 100; j+=i) {
					sieve[j] = true;
				}
			}
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();		//Added for junit testing
		for(int i = 0; i<sieve.length;i++) {
			if(!sieve[i])primes.add(i);
		}		
		return primes;
	}

	public static void printPrimes() {
		for(int i =0; i<sieve.length; i++) {
			if(!sieve[i]) {
				System.out.print(" "+i);
			}
		}
	}
}

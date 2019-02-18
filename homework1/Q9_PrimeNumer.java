package com.revature.homework1;
import java.util.ArrayList;
/*
 * Terrence Thomas
 * 02/14/2019
 */

public class Q9_PrimeNumer {
	// create the list to hold integers to test
	/*
	 * With the primeNumbers Method, I define a Prime as a number who's modulus zero 
	 * exists only twice i.e division by 1 and itself are the only possible mod zeros.
	 * Therefore, any number with n % [(n-1),(n-2),(n-3),...(n-(n-1))] = 0 is not a Prime number
	 */
	
 	public ArrayList<Integer> primeNumbers(ArrayList<Integer>list) {
 		ArrayList<Integer> newList = new ArrayList<Integer>();
		int count = 0;	// modulus counter
		int total = 0;	// to count the number of primes
		
		// iterate throught the list
		for(int i=0; i<list.size();i++) {
			// divide each i for n through i inclusive
			for(int n=0; n<=list.get(i);n++) {
				// avoid division by zero
				if(n>0) {
					// check number of mod zeros
					if(list.get(i)%n == 0) {
						count++;	// add up mod zeros
					}
					// stop the loop ones the number of mod zeros > 2. Not a prime by definition
					if(count>2) {
						break;
					}
				}
			}
			// check for primes
			if(count==2) {
				//System.out.println(list.get(i)); // print the Prime
				newList.add(list.get(i));
				total++;						// add to total number of primes
			}
			count = 0;							// reset the mod counter
		}
		System.out.println("-----------------------------------------");
		System.out.println("Number of Primes =  " + total);
		
		return newList;
	}
	public static void main(String[] args) {
		// access to primeNumebrs Method
		Q9_PrimeNumer prime = new Q9_PrimeNumer();
		ArrayList<Integer> list = new ArrayList<Integer>();
		// add set to the List
		for(int i=1; i<=100; i++) {
			list.add(i);
		}
		System.out.println("----------------------------");
		System.out.println("Prime numbers in set 100 are");
		System.out.println("----------------------------");
		System.out.println(prime.primeNumbers(list));	// calculate primes
	}

}

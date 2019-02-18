package com.revature.homework1;

import java.util.ArrayList;

public class FindPrimeNumbers {
	
 	public static ArrayList<Integer> primeNumbers(ArrayList<Integer>list) {
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
		
		return newList;
 	}
}

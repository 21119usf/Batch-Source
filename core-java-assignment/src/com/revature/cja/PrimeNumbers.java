// Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.

package com.revature.cja;

import java.util.ArrayList;

public class PrimeNumbers {
	
	private ArrayList<Integer> al = new ArrayList<>();
	
	// method to generate numbers from 1 to 100
	public void generateNumbers() {
		for (int i = 1; i <= 100; i++) {
			al.add(i);
		}
	}

	// method to check if number is prime or not
	public boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	// method to display prime numbers
	public void displayPrimeNumbers() {
		for(Integer i : al) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}

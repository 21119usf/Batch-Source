package com.revature.question9;

import java.util.ArrayList;

//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.

public class QuestionNine {
	//have a constant max value to test, in this case 100
	static int MAXTEST = 100;
	
	public static void main(String[] args) {
		//initializing the two ArrayLists
		ArrayList<Integer> primeTest = new ArrayList<>();
		ArrayList<Integer> primes = new ArrayList<>();
		//Populating the testing ArrayList
		for (int i = 1; i <= MAXTEST; i++) {
			primeTest.add(i);
		}
		//Running the primeTester method
		primeTester(primeTest,primes);
		
		//Spitting out the primes ArrayList
		System.out.println(primes);
	}
	
	//primeTester method
public static void primeTester(ArrayList<Integer> primeTest, ArrayList<Integer> primes) {

	int length = primeTest.size();
	for (int i = 1; i < length;i++) {
//setting a boolean value to more easily reference in the code
		boolean prime = true;
		int testnum = primeTest.get(i);
//		System.out.println(testnum);
		//biggest number difference for a nonprime is 2 times half of itself, so that's what we go up to
		for (int j = 2; j <= testnum/2; ++j) {
			//if modulo is zero, it has no remainder ie not a prime
			if (testnum%j == 0) {
				prime = false;
				break;
			}
			
		}
		//after running the for loop, add it to the primes ArrayList if prime is still true
		if (prime) {
			primes.add(testnum);
			//if I wanted to print out if it was a prime
//			System.out.println(testnum + " is a Prime");
		}
		//if I wanted to print out when it wasn't a prime
//		else {
//			System.out.println(testnum + " is NOT a Prime");
//		}
		
		}
	}

}

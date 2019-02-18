package com.revature.Q19;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListStuff {
	
	public static void main(String[] args) {
		/*
		 * Create arrayList and populate with numbers 1-10 
		 * printing them as we go
		 */
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			nums.add(i);
			System.out.print(i+" ");
		}
		System.out.println();
		/*
		 * Create int array to save odd sum and even
		 *  sum returned from oddEvenSums and print
		 */
		int[] oddEven = oddEvenSums(nums);
		System.out.println("Even sum: "+oddEven[1]);	
		System.out.println("Odd sum: "+oddEven[0]);
		/*
		 * Remove primes from arrayList nums and
		 * print
		 */
		removePrimes(nums);
		System.out.print("ArrayList without primes: ");
		for(Integer n : nums)System.out.print(" "+n );
	}
	
	/*oddEvenSums
	 * Input	: ArrayList<Integer>
	 * Output	: int[]
	 * Algo		: First create an int array to store even and odd sums
	 * 			  where the odd sum is held in the 0 index and even in 1.
	 * 			  Next loop through the ArrayList and test if the Integers
	 * 			  divison by 2 results in a remainder. If not its even, add it
	 * 			  to the even sum, else add it to the odd. Return the result.
	 */
	public static int[] oddEvenSums(ArrayList<Integer> nums) {
		int[] oddEven = new int[2];
		oddEven[0] = 0;
		oddEven[1] = 0;
		int n;
		for(int i=0; i < nums.size(); i++) {
			n = nums.get(i);
			if(n%2 == 0) {
				oddEven[1] += n;
			}else{
				oddEven[0] += n;
			}
		}
		return oddEven;
	}
	
	/*removePrimes
	 * Input	: ArrayList<Integer>
	 * Output	: void
	 * Algo		: First we create an iterator from our arrayList. This 
	 * 			  is so we can remove elements while iterating through it
	 * 			  without the problem of having to keep track of index's
	 * 			  after they are rearranged. We iterate on our iterator
	 * 			  calling checkPrime on each element. If true, remove;
	 * 
	 */
	public static void removePrimes(ArrayList<Integer> nums) {
		ListIterator<Integer> litr = nums.listIterator();
		int n;
		while(litr.hasNext()) {
			n = litr.next();
			if(checkPrime(n)) {
				litr.remove();
			}
		}
	}
	
	/*checkPrime
	 * Input	: int
	 * Output	: boolean
	 * Algo		: Return false if n = 1 because our loop doesn't check for 1
	 * 			  next we loop from 2 to the square root of n because for any number
	 *			  number n it must have a factor less than its square root, if prime this 
	 *			  number is 1. As we loop we check if the number has a divisor. If it doesn't
	 *			 return true
	 */
	public static boolean checkPrime(int n) {
		if(n == 1)return false;
		for(int i = 2; i <= Math.sqrt(n);i++) {
			if(n%i == 0)return false;
		}
		return true;
	}
}

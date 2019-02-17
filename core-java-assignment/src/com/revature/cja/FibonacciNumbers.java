// Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.

package com.revature.cja;

public class FibonacciNumbers {
	
	private int[] fibNums;
	
	// constructor
	public FibonacciNumbers(int n) {
		fibNums = new int[n];
	}
	
	// calculate fibonacci numbers
	public void calcFibNums() {
		for (int i = 0; i < fibNums.length; i++) {
			if (i == 0 || i == 1) {
				fibNums[i] = i;
			} else {
				fibNums[i] = fibNums[i - 1] + fibNums[i - 2];
			}
		}
	}	
	
	// get array
	public int[] getFibNumsArray() {
		return fibNums;
	}
}

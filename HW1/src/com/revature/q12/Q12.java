package com.revature.q12;

import java.util.ArrayList;

public class Q12 {

	public static void main(String[] args) {

		// store 1 to 100 in an array
		// print out evens with enhanced loop

		ArrayList<Integer> hundred = new ArrayList<Integer>();
		
		
		//Populating the array 
		for (int i = 1; i <= 100; i++) {
			hundred.add(i);
			//System.out.println(hundred);
		}
		
		//traversing the array and printing even numbers
		for(int j  : hundred) {
			if (isEven(j)) {
				System.out.print(j + " ");
			}
		}

	}
	
	/*
	 * Checking a number if it is even by seeing if the decimal is 0
	 */
	private static boolean isEven(int number) {
		return number%2 == 0;
	}

}

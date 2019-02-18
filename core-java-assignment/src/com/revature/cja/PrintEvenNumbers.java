//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even
//numbers from the array. Use the enhanced FOR loop for printing out the numbers.

package com.revature.cja;

public class PrintEvenNumbers {
	
	private int[] nums;
	
	// constructor
	public PrintEvenNumbers() {
		nums = new int[101];
		generateNums();
	}
	
	// generate nums from 1 to 100
	private void generateNums() {
		for (int i = 1; i <= 100; i++) {
			nums[i] = i;
		}
	}
	
	// display even numbers using enhanced for loop
	public void displayEvenNums() {
		for (int i : nums) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}

package com.revature.core.homework;

import java.util.ArrayList;

// #12
public class ArrayListNumbers {
	public static ArrayList<Integer> getEven(int n) {
		// array to store all numbers from 1 to n
		int[] numbers = new int[n];
		// array list to store even numbers in
		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		// loop to add the numbers to the array
		for (int i = 1; i <= n; i++) {
			numbers[i-1] = i;
		}
		/*
		 * loops through numbers array to populate evenNumbers ArrayList with even numbers
		 */
		for (int x : numbers) {
			if ((x%2) == 0) {
				evenNumbers.add(x);
			}
		}
		return evenNumbers;
	}
	
	public static void main(String[] args) {
		for (int x : getEven(100)) {
			System.out.println(x);
		}
	}
}

package com.revature.core.homework;

import java.util.ArrayList;

// #12
public class NumberArray {

	public static Integer[] getEvens(int x) {
		// list to populate numbers 1-n
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		// list to populate even numbers
		ArrayList<Integer> even = new ArrayList<Integer>();
		// populate numbers 1-n into numbers
		for (int i = 1; i <= x; i++) {
			numbers.add(i);
		}
		// lopp through numbers if number is even add it to even list
		for (int num : numbers) {
			if ((num % 2) == 0) {
				even.add(num);
			}
		}
		
		// convert even list to array
		return even.toArray(new Integer[even.size()]);
	}
	
	public static void main(String[] args) {
		for (int x: getEvens(100)) {
			System.out.println(x);
		}
	}
}

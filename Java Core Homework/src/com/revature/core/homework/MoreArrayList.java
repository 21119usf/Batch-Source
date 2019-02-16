package com.revature.core.homework;

import java.util.ArrayList;
// #19
public class MoreArrayList {
	public static void run(int n) {
		// list to populate numbers 1-n
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		// sum of odd numbers
		int odd = 0;
		// sum of even numbers
		int even = 0;
		// populate numbers list
		for (int i = 1 ; i <= n; i++) {
			numbers.add(i);
		}
		System.out.println(numbers);
		// loop through numbers
		for (int x : numbers) {
			// if even add to even sum
			if ((x % 2) == 0) {
				even += x;
			} else {
				// if odd add to odd sum
				odd += x;
			}
		}
		System.out.println("Even Sum" + even);
		System.out.println("Odd Sum" + odd);
	}
}

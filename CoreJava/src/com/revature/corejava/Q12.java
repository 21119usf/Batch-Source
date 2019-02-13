package com.revature.corejava;

// Print even numbers from 1 to n
public class Q12 {
	// Generate an array from 1 to n
	public static int[] generateArray(int n) {
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		return arr;
	}
	
	// Get even numbers from int[]
	public static int[] getEvens(int[] arr) {
		int[] evens = new int[arr.length/2];
		int idx = 0;
		for (int i : arr) {
			if (i%2 == 0) {
				evens[idx] = i;
				idx++;
			}
		}
		return evens;
	}
	
	// Main
	public static void main(String[] args) {
		int[] arr = generateArray(100);
		int[] evens = getEvens(arr);
		for (int i : evens) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

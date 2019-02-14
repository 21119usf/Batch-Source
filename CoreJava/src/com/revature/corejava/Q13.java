package com.revature.corejava;

// Display a binary triangle of n rows
public class Q13 {
	// Get nth triangular number
	public static int nthTriangular(int n) {
		return n*(n+1)/2;
	}
	
	// Generate n-length array of alternating 0, 1
	public static int[] generateArray(int n) {
		int nthTriangular = nthTriangular(n);
		int[] arr = new int[nthTriangular];
		for (int i=0; i<nthTriangular; i++) {
			if (i%2 == 0) {
				arr[i] = 0;
			} else {
				arr[i] = 1;
			}
		}
		return arr;
	}
	
	// Check if n is triangular
	public static boolean isTriangular(int n) {
		double d = Math.sqrt(8*n + 1);
		return (d - Math.floor(d) == 0);
	}
	
	// Print triangle of 0, 1 from array
	public static void printTriangle(int[] arr) {
		for (int i=1; i<=arr.length; i++) {
			System.out.print(arr[i-1] + " ");
			if (isTriangular(i)) {
				System.out.println();
			}
		}
	}
	
	// Main
	public static void main(String[] args) {
		int n = 4;
		int[] arr = generateArray(n);
		printTriangle(arr);
	}
}

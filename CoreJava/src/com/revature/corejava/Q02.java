package com.revature.corejava;

// Class to compute the first n Fibonacci numbers
public class Q02 {
	private int n;
	
	// Default constructor
	Q02() {
		this.n = 25;
	}
	
	// Constructor to assign custom Fib index
	Q02(int idx) {
		this.n = idx;
	}
	
	// List Fibonacci numbers up to n
	public void fib() {
		int[] list = new int[this.n];
		
		// Compute and store Fibonacci numbers
		for (int i=0; i<this.n; i++) {
			if (i==0) {
				list[i] = 0;
			}
			else if (i==1) {
				list[i] = 1;
			}
			else {
				list[i] = list[i-2] + list[i-1];
			}
		}
		
		// Output Fibonacci numbers
		for (int i:list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// Main
	public static void main(String[] args) {
		// Default
		Q02 q0 = new Q02();
		q0.fib();
		
		// Custom
		Q02 q1 = new Q02(10);
		q1.fib();
	}
}

package com.revature.corejava;

// Minimum of two numbers
public class Q10 {
	// Find the minimum of n and m
	public static int minimum(int n, int m) {
		return n < m ? n : m;
	}
	
	// Main
	public static void main(String[] args) {
		int n = 20;
		int m = 3;
		System.out.println(minimum(n, m));
	}
}

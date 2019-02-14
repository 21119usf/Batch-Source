package com.revature.corejava;

// Question 15 solution
public class Q15 implements Q15Interface {
	public int addition(int a, int b) {
		return a+b;
	}
	public int substraction(int a, int b) {
		return a-b;
	}
	public int multiplication(int a, int b) {
		return a*b;
	}
	public int division(int a, int b) {
		return a/b;
	}
	
	// Main
	public static void main(String[] args) {
		Q15 q0 = new Q15();
		int sum = q0.addition(10, 11);
		System.out.println(sum);
	}
}

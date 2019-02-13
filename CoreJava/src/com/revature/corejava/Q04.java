package com.revature.corejava;

// Class to compute n-factorial
public class Q04 {
	private int n;
	
	// Default constructor
	Q04() {
		this.n = 9;
	}
	
	// Custom constructor
	Q04(int i) {
		this.n = i;
	}
	
	// Compute factorial
	public int computeFactorial() {
		if (this.n == 0 || this.n == 1) {
			return 1;
		}
		
		int result = 1;
		for (int i=this.n; i>0; i--) {
			result *= i;
		}
		
		return result;
	}
	
	// Main
	public static void main(String[] args) {
		// Default
		Q04 q0 = new Q04();
		System.out.println(q0.computeFactorial());
		
		// Custom
		Q04 q1 = new Q04(6);
		System.out.println(q1.computeFactorial());
	}
}

// Q4. Write a program to compute N factorial.

package com.revature.cja;

public class ComputeNFactorial {
	
	private int num;
	
	// constructor
	public ComputeNFactorial(int num) {
		this.num = num;
	}
	
	// computes factorial
	public int computeFactorial() {
		if (num == 0) {
			return 1;
		}
		
		int fact = 1;
		
		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		
		return fact;
	}
}

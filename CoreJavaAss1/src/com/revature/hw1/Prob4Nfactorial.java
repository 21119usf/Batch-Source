package com.revature.hw1;

public class Prob4Nfactorial {
	
	public static void main(String[] args) {
		int temp = 1;
		int factorial = 7;
		
		System.out.println("factorial of N");
		System.out.println("==============");
		for(int n = factorial; n > 0; n--) {
			temp = temp*n; 
			
			
		}
		System.out.println("The factorial of: " + factorial + " is " + temp);
	}

}

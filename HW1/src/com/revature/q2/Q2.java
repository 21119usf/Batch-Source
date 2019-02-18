package com.revature.q2;

public class Q2 {
	public static void main(String[] args) {
		int term1 = 0;
		int term2 = 1;
		
		for(int i = 1; i <= 25; i++) {
			System.out.print(term1 + " ");
			int sum = term1 + term2; //adding the two numbers to assign to term 2
			term1 = term2;//  assigning  second number to  the first number to not lose it
			term2 = sum; // then assigning the original sum to term2  to repeat the cycle
		}
	}

}

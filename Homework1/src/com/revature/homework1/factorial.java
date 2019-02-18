package com.revature.homework1;

public class factorial {
	/*
	 * we test the input to make sure it isnt less than 2 because if it is its is 1 or 0 and those 
	 * as factorials are 1. if n is greater than 2 we multiply the value by the value -1 recursively
	 * until we reach a value less than 2... 4 = 4*3*2*1
	 */
	public static int fact(int n) {
		int x = (n < 2) ? 1 : n*fact(n-1);
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(fact(4));
	}

}

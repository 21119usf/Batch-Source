package com.revature.homework1;

public class MyInterfaces implements MyInterface { //we then provide functionality for the interface methods
													//we take in two numbers as parameters for each function and perform the 
													//math functions of adding, subtracting, dividing, and multiplying
	@Override 
	public int addition(int a, int x) {
		int sum = a + x;
		return sum;
	}

	@Override
	public int subtraction(int a, int x) {
		// TODO Auto-generated method stub
		int sub = a - x;
		return sub;
	}

	@Override
	public int multiplication(int a, int x) {
		// TODO Auto-generated method stub
		int mult = a*x;
		return mult;
	}

	@Override
	public int division(int a, int x) {
		// TODO Auto-generated method stub
		int div = a/x;
		return div;
	}

	

	

}

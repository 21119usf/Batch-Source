package com.revature.Q15;

public class Calculator implements CalculatorFuncs{
	
	
	public Calculator() {
		super();
	}

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

	@Override
	public int mult(int a, int b) {
		return a*b;
	}
}


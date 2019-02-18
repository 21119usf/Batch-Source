package com.revature.assignment1;

public class Q15ImplementingClass implements Q15Interface {//demonstration of implementing interface

	@Override
	public int addition(int a, int b) {//simple addition method
		return a+b;
	}

	@Override
	public int subtraction(int c, int d) {//simple subtraciton
		return c-d;
	}

	@Override
	public int multiplication(int e, int f) {//simple multiplication
		return e*f;
	}

	@Override
	public int division(int g, int h) {//simple divisiuont
		return g / h;
	}

}

package com.revature.core.homework;
// #15
public class Calculator implements Calculateable {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@Override
	public int devide(int a, int b) {
		return a / b;
	}

}

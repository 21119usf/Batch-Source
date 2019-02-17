package com.revature.cja;

public class SimpleMethodsClass implements SimpleMethods {

	// method that adds num1 and num2
	@Override
	public int addition(int num1, int num2) {
		return num1 + num2;
	}

	// method that subtracts num2 from num1
	@Override
	public int subtraction(int num1, int num2) {
		return num1 - num2;
	}

	// method that multiplies num1 and num2
	@Override
	public int multiplication(int num1, int num2) {
		return num1 * num2;
	}

	// method that divides num2 from num1
	@Override
	public int division(int num1, int num2) {
		return num1 / num2;
	}
	
}

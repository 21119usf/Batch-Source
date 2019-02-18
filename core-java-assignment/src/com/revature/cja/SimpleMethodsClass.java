//Q15. Write a program that defines an interface having the following methods: addition,
//subtraction, multiplication, and division. Create a class that implements this interface
//and provides appropriate functionality to carry out the required operations. Hard code
//two operands in a test class having a main method that calls the implementing class.

package com.revature.cja;

public class SimpleMethodsClass implements SimpleMethods {

	// method that adds num1 and num2
	@Override
	public double addition(double num1, double num2) {
		return num1 + num2;
	}

	// method that subtracts num2 from num1
	@Override
	public double subtraction(double num1, double num2) {
		return num1 - num2;
	}

	// method that multiplies num1 and num2
	@Override
	public double multiplication(double num1, double num2) {
		return num1 * num2;
	}

	// method that divides num2 from num1
	@Override
	public double division(double num1, double num2) {
		return num1 / num2;
	}
	
}

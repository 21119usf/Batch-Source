//Q15. Write a program that defines an interface having the following methods: addition,
//subtraction, multiplication, and division. Create a class that implements this interface
//and provides appropriate functionality to carry out the required operations. Hard code
//two operands in a test class having a main method that calls the implementing class.

package com.revature.cja;

public interface SimpleMethods {
	double addition(double num1, double num2);
	double subtraction(double num1, double num2);
	double multiplication(double num1, double num2);
	double division(double num1, double num2);
}

package com.revature.question15;
//Q15. Write a program that defines an interface having the following methods: 
//addition, subtraction, multiplication, and division.  Create a class that 
//implements this interface and provides appropriate functionality to carry 
//out the required operations. Hard code two operands in a test class having 
//a main method that calls the implementing class.

public interface OperatorInterface {
	//interface that houses the four methods
void addition(int x, int y);
void subtraction(int x, int y);
void multiplication(int x, int y);
//division is of type double so that th eanswer can have more precision; x and y will be cast as double
double division(int x, int y);
}

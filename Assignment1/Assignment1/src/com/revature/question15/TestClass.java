package com.revature.question15;
//Q15. Write a program that defines an interface having the following methods: 
//addition, subtraction, multiplication, and division.  Create a class that 
//implements this interface and provides appropriate functionality to carry 
//out the required operations. Hard code two operands in a test class having 
//a main method that calls the implementing class.
public class TestClass {
		//two hard-coded operands. x was made larger to ensure no negative answers/small decimals
	static int x = 78;
	static int y = 15;
	
	public static void main(String[] args) {
		//initiating the QuestionFifteen class
		QuestionFifteen calls = new QuestionFifteen();
		//calling the methods contained in QuestionFifteen
		calls.addition(x, y);
		calls.subtraction(x, y);
		calls.multiplication(x, y);
		//no need to case as double for division, as that's done in the method
		calls.division(x, y);
	}

}

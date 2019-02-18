package com.revature.question15;

//Q15. Write a program that defines an interface having the following methods: 
//addition, subtraction, multiplication, and division.  Create a class that 
//implements this interface and provides appropriate functionality to carry 
//out the required operations. Hard code two operands in a test class having 
//a main method that calls the implementing class.

//the implementing class
public class QuestionFifteen implements OperatorInterface{


	public void addition(int x, int y) {
		int sum = x + y;
		//output sum of x and y
		System.out.println("The sum of " + x + " and " + y + " is: " + sum);
	}

	public void subtraction(int x, int y) {
		int difference = x - y;
		//output difference between x and y
		System.out.println("The difference between " + x + " and " + y + " is: " + difference);
	}

	public void multiplication(int x, int y) {
		int product = x * y;
		//output product of x and y
		System.out.println("The product of " + x + " and " + y + " is: " + product);
	}

	public double division(int x, int y) {
		//if statement to prevent division by zero exception
		if (y == 0) {
			System.out.println("You cannot divide by zero.");
			
		}
		else {
			//casting x and y as a double so the quotient will e more precise
			double quotient = (double) x / (double) y;
			System.out.println("The quotient of " + x + " divided by " + y + " is: " + quotient);
		}
		//return value necessary since not void
		return 0;
				
	}

}

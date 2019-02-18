package com.revature.q15;

/*
 * Calculator implements the interface calculate that requires to fill out the methods  that are in that interface
 */
public class Calculator implements Calculate {


	@Override
	public void addition(int a, int b) {
		int sum = a + b ;
		System.out.println("Adding " + a + " + " + b + " = " + sum);
	}

	@Override
	public void subtraction(int a, int b) {
		int sum = a - b ;
		System.out.println("Subracting " + a + " - " + b + " = " + sum);
		
	}

	@Override
	public void multiplacation(int a, int b) {
		int sum = a * b ;
		System.out.println("Multiplying " + a + " * " + b + " = " + sum);
		
	}

	@Override
	public void division(int a, int b) {
		int sum = a / b ;
		System.out.println("Dividing " + a + " / " + b + " = " + sum);
		
	}
	
	

}

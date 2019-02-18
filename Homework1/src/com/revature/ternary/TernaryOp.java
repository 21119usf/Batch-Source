package com.revature.ternary;

public class TernaryOp {

	public static void main(String[] args) {
		//Declare the variables
		int num1 = 23, num2 = 32, min;
		
		//Find out which is smaller
		min = (num1 < num2) ? num1 : num2;
		//Display
		System.out.println("The minimum number between "+ num1 +" and " + num2 + " is " + min);

	}

}

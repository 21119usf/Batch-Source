package com.revature.question11;

import com.revature.question11values.*;;

public class Question11 {

	//Write a program that would access two float-variables 
	//from a class that exists in another package. 
	//Note, you will need to create two packages to demonstrate the solution.
	
	
	
	public static void sum(float a, float b) {
		float c = a + b;
		System.out.println("The sum of " + a + " and " + b + " is " + c);
	}
	
	public static void difference(float a, float b) {
		float c = a - b;
		System.out.println("The difference of " + a + " and " + b + " is " + c);
	}
	
	public static void main(String[] args) {

		sum(Question11Values.value1, Question11Values.value2);
		difference(Question11Values.value1, Question11Values.value2);
		
	}

}

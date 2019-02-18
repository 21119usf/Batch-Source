package com.revature.assignment1;

public class Q15Test {

	public static void main(String[] args) {
		
		int a = 6;//integers hardcoded to test interface
		int b = 3;
		
		//object implementation
		Q15ImplementingClass implementDemo = new Q15ImplementingClass();
		
		//display of results from the method call of the implemented methods
		System.out.println("6 and 3 added is "+implementDemo.addition(a, b));
		System.out.println("6 and 3 subtracted is "+implementDemo.subtraction(a, b));
		System.out.println("6 and 3 multiplied is "+implementDemo.multiplication(a, b));
		System.out.println("6 and 3 divided is "+implementDemo.division(a, b));
	}

}

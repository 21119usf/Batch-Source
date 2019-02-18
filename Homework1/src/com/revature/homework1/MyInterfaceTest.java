package com.revature.homework1;

public class MyInterfaceTest { //class to test myinterfaces and myinterface are working correctly
								//we establish two integers and a new instance of the Myinterfaces class
								//and perform each method on those two integers

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 15;
		MyInterfaces theTest = new MyInterfaces();
		
		System.out.println(theTest.addition(a, b));
		System.out.println(theTest.division(a, b));
		System.out.println(theTest.multiplication(a, b));
		System.out.println(theTest.subtraction(a, b));
		
		
	}

}

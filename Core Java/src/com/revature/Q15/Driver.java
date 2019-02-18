package com.revature.Q15;

public class Driver {

	public static void main(String[] args) {
		Calculator test = new Calculator();
		int a = 10;
		int b = 5;
		System.out.println("a = "+a+" b = "+b);
		System.out.println("ADD: "+test.add(a, b));
		System.out.println("SUB: "+test.sub(a, b));
		System.out.println("DIV: "+test.div(a, b));
		System.out.println("MULT: "+test.mult(a, b));
	}

}

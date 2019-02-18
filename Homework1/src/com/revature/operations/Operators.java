package com.revature.operations;

public class Operators implements Interface {

	/*Methods:
	 * addition
	 * subtraction
	 * multiplication
	 * division
	 */
	
	public int add(int a, int b) {
		return a+b;
	}
	public int subtract(int a, int b) {
		return a-b;
	}
	public int multiply(int a, int b) {
		return a*b;
	}
	public int divide(int a, int b) {
		return a/b;
	}
	
	public static void main(String[] args) {
		Operators math = new Operators();
		System.out.println(math.add(23,32));
		System.out.println(math.subtract(23,32));
		System.out.println(math.multiply(23,32));
		System.out.println(math.divide(23,32));

	}

}

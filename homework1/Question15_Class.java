package com.revature.homework1;

public class Question15_Class implements Question15_Interface{

	@Override
	public int addition(int x, int y) {
		return x+y;
	}
	@Override
	public int subtraction(int x, int y) {
		return x-y;
	}
	@Override
	public int multiplicaion(int x, int y) {
		return x*y;
	}
	@Override
	public double division(double x, double y) {
		try {
			return x/y;
		}catch(Exception e) {System.out.println("Division by Zero. Try again.");};
		return 0;
	}
	
	public static void main(String[] args) {
		Question15_Class a = new Question15_Class();
		System.out.println(" 5 + 2 = " + a.addition(5,2));
		System.out.println(" 5 - 2 = " + a.subtraction(5,2));
		System.out.println(" 5 * 2 = " + a.multiplicaion(5,2));
		System.out.println(" 5 / 2 = " + a.division(5,0));

	}

}

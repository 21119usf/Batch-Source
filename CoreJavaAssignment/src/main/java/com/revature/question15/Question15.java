package com.revature.question15;

public class Question15 implements MathInterface{

	private int i1;
	private int i2;
	
	public Question15() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question15(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}

	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}

	@Override
	public String toString() {
		return "Question15 [i1=" + i1 + ", i2=" + i2 + "]";
	}
	
	@Override
	public void addition(int a, int b) {
		int c = a + b;
		System.out.println("Addition: " + a + " + " + b + " = " + c);
	}
	
	@Override
	public void subtraction(int a, int b) {
		int c = a - b;
		System.out.println("Addition: " + a + " - " + b + " = " + c);
	}
	
	public void multiplication(int a, int b) {
		int c = a * b;
		System.out.println("Addition: " + a + " * " + b + " = " + c);
	}
	
	@Override
	public void division(int a, int b) {
		int c = a / b;
		System.out.println("Addition: " + a + " / " + b + " = " + c);
	}
	
	public static void main(String[] args) {
		Question15 calculator = new Question15(6, 3);
		
		
		calculator.addition(calculator.i1, calculator.i2);
		calculator.subtraction(calculator.i1, calculator.i2);
		calculator.multiplication(calculator.i1, calculator.i2);
		calculator.division(calculator.i1, calculator.i2);
		
	}
	


}

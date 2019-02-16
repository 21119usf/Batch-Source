package com.revature.example;

import java.util.Scanner;

public class ExceptionExample {
	
	public static double divideByNum(double x, double y) throws Exception{
		if (y == 0)
			throw new Exception();
		return x/y;
	}
	
//	public static int divideByNum(int x, int y){
//		return x/y;
//	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
//		int x, y, result;
		double x, y, result;
		
		
		System.out.print("Please input a number to divide: ");
		x = input.nextInt();
		System.out.print("Please input a number to divide by: ");
		y = input.nextInt();
		result = 0;
		
		
//		result = divideByNum(x, y);
		try {
			result = divideByNum(x, y);
		}
		catch (Exception e) {
			System.out.println("Division by zero exception");
		}
		
		System.out.println("The answer is : " + result);
	}
}

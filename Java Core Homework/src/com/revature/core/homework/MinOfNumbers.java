package com.revature.core.homework;

// #10
public class MinOfNumbers {
	public static int run(int num1, int num2) {
		return num1 > num2 ? num2 : num1;
	}

	public static void main(String[] args) {
		System.out.println(MinOfNumbers.run(2, 1));
	}
}

package com.revature.hw1;

public class Prob10ternarynumbers {

	static int num1 = 11;
	static int num2 = 9;
	static String msg = num1 < num2
			? num1 + " is the minimum number"
			: num2 + " is the minimum number";
	public static void main(String[] args) {
		System.out.println(msg);

	}

}

package com.revature.hw1prob15;

public class Calculator implements Calculate {

	//edit variables here. not sure if this is what was asked but it works lol
	static double x = 9;
	static double y = 3;
	static double answer = 0;
	
	@Override
	public double add() {
		answer = x+y;
		System.out.println(answer);
		return 0;
	}

	@Override
	public double subtract() {
		answer = x-y;
		System.out.println(answer);
		return 0;
	}

	@Override
	public double multiply() {
		answer = x*y;
		System.out.println(answer);
		return 0;
	}

	@Override
	public double divide() {
		answer = x/y;
		System.out.println(answer);
		return 0;
	}

}

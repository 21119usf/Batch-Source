package com.revature.example;

public class Overload {
	public static void OverloadMethod(String phrase1, String phrase2) {
		System.out.println(phrase1 + " " + phrase2);
	}
	
	public static void OverloadMethod(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void OverloadMethod(Double x, Double y) {
		System.out.println(x.intValue() + y.intValue());
	}
	
	public static void OverloadMethod(int ... i) {
		for (int x : i) {
			System.out.print(Integer.toString(x));
		}
	}

	public static void main(String[] args) {
		OverloadMethod("Hello", "There");
		OverloadMethod(3,4);
		OverloadMethod(3.88, 2.9);
		OverloadMethod(7,9,5,7,6);
	}
}
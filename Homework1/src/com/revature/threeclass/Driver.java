package com.revature.threeclass;

public class Driver {

	public static void main(String[] args) {
		String str = "BIG and small";
		Substring test = new Substring();
		System.out.println(test.containsUpper(str));
		System.out.println(test.changeUpper(str));
		System.out.println(test.addString(str));

	}

}

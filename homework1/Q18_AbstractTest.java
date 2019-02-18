package com.revature.homework1;

public class Q18_AbstractTest {

	public static void main(String[] args) {
		Q18_Class test = new Q18_Class();
		boolean b = test.checkUpperCase("helLo");
		System.out.println(b);
		String str = test.toUpperC("Lkh");
		System.out.println(str);
		int i = test.toInt("78a");
		System.out.println(i);
	}

}

package com.revature.varargs;

public class FunWithVarargs {

	static void vaTest(int ... i) {
		System.out.println("Number of Args is : " + i.length + "\nContents: ");
		for (int x: i) {
			System.out.println("\t" + x);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		vaTest(10);
		System.out.println("====================");
		vaTest(1,2,3,4,5,6,7,8,9,10);
		System.out.println("====================");
	}

}

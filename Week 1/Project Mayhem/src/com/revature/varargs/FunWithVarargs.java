package com.revature.varargs;

public class FunWithVarargs {

	static void vaTest(int ... v) {
		System.out.println("Number of Args is : " +v.length+  "COntents:");
		for(int x :v) {
			System.out.println(x+ " ");
		}
	}
	public static void main(String[] args) {
		vaTest(10);
		System.out.println("===============");
		vaTest(1,2,3,4,5,5,6,7,8,9,21);
		System.out.println("===============");
		vaTest();

	}

}

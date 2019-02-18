package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		// Create a Gen1 Reference for Integers
		Gen1<Integer> i;
		i = new Gen1<Integer>(88);
			//show type of i
			i.showType();
		//get the value of i
			int v=i.getOb();
			System.out.println("value: " + v);
			Gen1<String> s = new Gen1<String>("Generics Test");
			s.showType();
			String str = s.getOb();
			System.out.println("value: " + str);
	}

}

package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		//Create a Gen1 Reference for Integers
		Gen1<Integer> i;
		i = new Gen1<Integer>(88);
		
		//show type of i
		i.showType();
		
		//get value of i
		int v = i.getObj();
		
		System.out.println("value: " + v);
		
		//Create a Gen1 Reference for Strings
				Gen1<String> phrase1;
				phrase1 = new Gen1<String>("Generic Test");
				
				//show type of i
				phrase1.showType();
				
				//get value of i
				String phrase2 = phrase1.getObj();
				
				System.out.println("value: " + phrase2);
	}
}

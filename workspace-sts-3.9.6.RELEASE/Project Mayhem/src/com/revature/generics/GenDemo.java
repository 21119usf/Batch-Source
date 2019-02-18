package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) 
	{
		//Create a Gen1 reference for Integers.
		Gen1<Integer> i;
		
		i = new Gen1<Integer>(88);
		
		//Show i's type
		i.showType();
		
		int v = i.getOb();
		System.out.println("value: " + v);

	}

}

package com.revature.varargs;

public class FunWithVarargs 
{
	static void VATest(int ...i)
	{
		System.out.println("Number of args is: " + i.length + " Contents: ");
		
		for(int x : i)
		{
			System.out.println(x + " ");
		}
	}

	public static void main(String[] args) 
	{
		VATest(10);
		System.out.println("----------------------------");
		VATest(1,2,3,4,5,6,7,8);
		System.out.println("----------------------------");
		VATest();

	}

}

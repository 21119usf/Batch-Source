package com.revature.wrappers;

public class Wrappers 
{
	static int myInt = 3;
	
	static Integer myInteger = 5;
	
	static Double myDouble = 3.14;
	
	static Boolean myBoolean = true;
	
	public static int sum(int a, int b)
	{
		return (a + b);
	}
	
	public static void main(String[] args)
	{
		System.out.println(sum(myInt, myDouble.intValue()));
	}
}

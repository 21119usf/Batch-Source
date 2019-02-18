package com.revature.generics;

public class Gen1<T> 
{
	/*
	 * Generics: using a type as a parameter.
	 * allows us to write code that handles different types of objects
	 * use angle brackets <> to denote that something is generics
	 * Allows us to ensure type safety.
	 * Adds stability and reusability to our code.
	 * Placeholder ex. <T> is used instead of a type.
	 */
	
	// Declare an object of type T
	T ob;
	
	//Pass the constructor a reference to an object of type T.
	
	public Gen1(T o)
	{
		ob = o;
	}
	
	T getOb()
	{
		return ob;
	}
	
	void showType()
	{
		System.out.println("Type of T is " + ob.getClass().getTypeName());
	}
}

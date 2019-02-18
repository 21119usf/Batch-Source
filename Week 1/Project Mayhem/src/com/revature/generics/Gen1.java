package com.revature.generics;
/*
 * Generics - placeholder for a type of project
 * Using a type as a parameter
 * write code that can handle different types of objects
 * use angle brackets <> to denote a generic
 * Allows us to ensure type safety
 * Adds stability and reusability to our code
 * Placeholder (T,E,?,etc.) - use instead of an explicit type
 */
public class Gen1<T> {
	//declare an object of type T
	T ob;
	//pass the constructor a reference to an object of type T
	Gen1(T o){
		ob=o;
		}
	//return ob
	T getOb() {
		return ob;
	}
	//Shows the Type of T
	void showType() {
		System.out.println("Type of T is: "+ob.getClass().getName());
	}
	
}

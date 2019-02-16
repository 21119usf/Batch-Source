package com.revature.generics;
/*Generics
 * using a type as a parameter
 * write code that can handle different types of objects
 * use angle brackets <> to denote that something is a generic
 * Allows us to ensure type safety
 * adds stability and re-usability to our code
 * Placeholder(T, E, ?, etc.)- use instead of an explicit type
 */
public class Gen1<T> {
	//declare an object of type T
	T obj;
	
	//pass the constructor a reference to an object of type T
	Gen1(T o) {
		obj = o;
	}
	
	//return obj
	T getObj() {
		return obj;
	}
	
	//show the Type of obj
	void showType() {
		System.out.println("Type of T is " + obj.getClass().getName());
	}
}

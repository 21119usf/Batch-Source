package com.revature.driver;

import com.revature.beans.Person;

public class Driver {
/*Naming Conventions
 * class and projects: Pascal - capitalize each word.
 * methods and variables: camelCase.
 * Package names: all lowercase, seperated by periods.
 * constants: ALL_CAPS.
 */
	//Main method is the entry point
	 public static void main(String[] args) {
		/*static: do not need to instantiate/ belongs to a class
		 * void: doesn't return anything
		 * String [] args- arguments to be utilized in a method
		 */
		System.out.println("Go Noles!");
		Person a = new Person("Kid",88,177);
		Person b = new Person("Lad",38,110);
		Person c = new Person("Chap",28,190);
		System.out.println(a.getName());
		System.out.println(b);
		System.out.println(c.getName());

		/*
		 * Members of a class- can have different forms
		 * Instance variables- Property that belongs to a specific object
		 * Static variables- Belongs to class/all instances 
		 * Instance methods- Behavior related to a specific object
		 * Static methods- Relative to the entire class
		 * Constructors- Instantiates the class using the keyword "new"
		 */
	}
}

package com.revature.driver;

import com.revature.beans.Person;
import com.revature.exceptions.IncreasedByNegativeNumberException;

//Package- namespace that organizes related classes/interfaces, etc
public class Driver {
	//single line comment
	
	/*
	 * this
	 * is
	 * a
	 * really
	 * long
	 * multi
	 * line
	 * comment
	 */
	
	/*
	 * Naming Conventions
	 * class and projects: Pascal- capitalize each word ex. ProjectMayhem
	 * methods and variables: comelCase- ex firstSecondThird
	 * Package names: all lowercase, serparated by periods
	 * constants: 	ALL_CAPS_LOLZ, delimited by underscores
	 */
	
	public static void main(String[] args) {
		/*
		 * Public: 
		 * Static: do not need to instantiate class to call method
		 * Void: doesn't return anything
		 * String[] args: array of strings called 'args'
		 */
		
		System.out.println("Roll Tide");
		Person A = new Person("Mark A Venegas", 26, 247);
		Person B = new Person("Matt", 32, 265);
		Person C = new Person("Sloan", 23, 230);
		System.out.println(A.getAge());
		
		try{
			A.increaseAgeBy(20);
			System.out.println(A.getAge());
			A.increaseAgeBy(-45);
			System.out.println(A.getAge());
		}
		catch (IncreasedByNegativeNumberException e) {
			e.printStackTrace();
		}
//		System.out.println(A);
//		System.out.println(B);
//		System.out.println(C);
		
		
		/*
		 * Members of a class- can have different forms
		 * instance variables- property that belongs to a specific object
		 * Static variables-  property that belongs to class/all instances
		 * instance methods- behavior related to a specific object
		 * Static methods- behavior related to the entire class
		 * Constructors- instantiates the class using the keyword "new"
		 */
	}
}

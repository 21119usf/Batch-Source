package com.revature.driver;

import com.revature.beans.Person;
import com.revature.exceptions.IncreasedByNegativeNumberException;

//Package- namespace that organizes related classes/interfaces, etc
public class Driver {
	//single line comment
	/*
	 * This
	 * is
	 * a
	 * really
	 * long
	 * multi
	 * line
	 * comment
	 */
	
	/*Naming Conventions
	 * class and projects: Pascal- capitalize each word, ex. ProjectMayhem
	 * methods and variables: camelCase- first word not, rest capitalize ex. firstSecondThird
	 * package name: all lowercase separated by periods
	 * Constants: ALL_CAPS delineated by underscores
	 */
	
	//Main Method is the entry point
	public static void main(String[] args) {
		/*
		 * static: do not need to instantiate; belongs to a class
		 * void: doesn't return anything
		 * String[] args: an array of strings named args to be utilized in a method
		 */
		System.out.println("Go UCF");
		Person a = new Person("Nick", 88, 177);
		Person b = new Person("Matt", 32, 265);
		Person c = new Person("Sloane", 23, 230);
		try{
			a.increaseAgeBy(20);
			System.out.println(a.getAge());
		}
		catch (IncreasedByNegativeNumberException e) {
			e.printStackTrace();
		}
		try{
			a.increaseAgeBy(-45);
			System.out.println(a.getAge());
		}
		catch (IncreasedByNegativeNumberException e) {
			e.printStackTrace();
		}
		
		
		
		//System.out.println(b);
		//System.out.println(c.getName());
		/*
		 * Members of a class- can have different forms
		 * Instance variables- property that belongs to a specific object
		 * Static variables- belongs to a class/all instances
		 * Instance methods- behaviour related to a specific object
		 * Static methods- relative to the entire class
		 * Constructors- instantiates the class using keyword "new"
		 */
	}

}

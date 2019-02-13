package com.revature.driver;

import java.sql.Date;

import com.revature.beans.Person;
import com.revature.exceptions.IncreasedByNegativeNumberException;

//Package- namespace that organizes related classess/interfaces,etc
public class Driver {
	/*@SuppressWarnings("deprecation")
	Date d= new Date(1,2,3);
	java.util.Date a= new Date(2); */
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
	
	/*Naming Conventions
	 * class and projects: Pascal- capitalize each word ex. ProjectMayhem
	 * methods and variables: camelCase- ex firstSecondThird
	 * Package names: all lowercase , separated by periods
	 * constants: ALL_CAPS_LOLZ
	 */
	//Main method is the entry point
	public static void main(String[] args) {
		/*
		 * static: do not need to instantiate/belongs a class
		 * void:doesn't return anything
		 * String [] args- arg to be utilized in a method
		 */
		System.out.println("Roll Tide");
		Person a= new Person("Nick",88, 177);
		Person b= new Person("Matt",32, 265);
		Person c= new Person("Sloan",23, 230);
		try{
			a.increaseAgeBy(20);
		System.out.println(a.getAge());
		}
		catch(IncreasedByNegativeNumberException e) {
			e.printStackTrace();
		}
		
		try{
			a.increaseAgeBy(-45);
		System.out.println(a.getAge());
		}
		catch(IncreasedByNegativeNumberException e) {
			e.printStackTrace();
		}
		
		/*System.out.println(a.getName());
		System.out.println(b);
		System.out.println(c.getName());*/
		
		/*
		 * Members of a class- can have different forms
		 * Instance variables- property that belongs to a specific object
		 * Static variables-belongs to class/all instances
		 * Instance methods-behavior related to a specific object
		 * Static methods- relative to the entire class
		 * Constructors-instantiates the class using the keyword "new"
		 */
	}
}

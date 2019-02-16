package com.revature.beans;

import java.io.Serializable;

import com.revature.classtypes.Hunt;
import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person implements Hunt, Serializable{
	
	private static final long serialVersionUID = 1252118972783119768L;
	
	/*
	 * Code Blocks- {things between curly braces}
	 */
	//Instance Code Block
	{System.out.println("im in an instance code block");}
	//Static code block
	static {System.out.println("Im in a static code block");}
	
	private String name;
	private transient int age; //adding 'transient' makes it so that the field is write only
	private int weight;
	
	static String homePlanet;
	
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public Person() {
		this("Mark", 24, 247);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return "Person's name: " + this.name +
				"\nAge: " + this.age +
				"\nWeight: " + this.weight;
	}
	
	public void increaseAgeBy(int x) throws IncreasedByNegativeNumberException{
		if (x < 0)
			throw new IncreasedByNegativeNumberException();
		this.age += x;
	}

	@Override
	public void findPrey() {
		// TODO Auto-generated method stub
		System.out.println("I got to Walmart, meeeegh");
	}
}







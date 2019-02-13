package com.revature.beans;

import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person {
	
	/*
	 * Code Blocks (CB)- {things between curly braces}
	 */
	//Instance CB
	{System.out.println("I'm in an instance code block");}
	//Static code block
	static {System.out.println("I'm in a static code block");}
	
	private String name;
	private int age;
	private int weight;
	static String homePlanet;
	//constructors
	public Person(String name, int age, int weight){
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	public Person() {
		super();
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public static String getHomePlanet() {
		return homePlanet;
	}
	public static void setHomePlanet(String homePlanet) {
		Person.homePlanet = homePlanet;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	public void increaseAgeBy( int x) throws IncreasedByNegativeNumberException {
		if (x < 0) {
			throw new IncreasedByNegativeNumberException ();
		}
		this.age+=x;
	}
//	public void increaseAgeBy( int x) throws IncreasedByNegativeNumberException {
//		this.age+=x;
//	}
}

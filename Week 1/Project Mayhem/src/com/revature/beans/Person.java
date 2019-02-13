package com.revature.beans;

import com.revature.classtypes.Hunt;
import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person implements Hunt{
	
	/*
	 * Code Blocks- {things between}
	 */
	//Instance CB
	{System.out.println("im in an instance code block");}
	//Static code block
	static {System.out.println("im in a static code block");}
	
	private String name;
	private int age;
	private int weight;
	static String homePlanet;
	//Constructors
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
	public void increaseAgeBy( int x) throws IncreasedByNegativeNumberException{
		if(x<0) {
			throw new IncreasedByNegativeNumberException();
		}
		this.age+=x;
	}
	@Override
	public void findPrey() {
		System.out.println(" I go to WalMart, meeeegh");
		
	}
}

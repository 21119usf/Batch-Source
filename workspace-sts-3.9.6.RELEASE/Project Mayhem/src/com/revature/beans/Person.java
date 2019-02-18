package com.revature.beans;

public class Person 
{
	{System.out.println("instance block of code");}
	
	static {System.out.println("static block of code");}
	
	private String name;

	private int age;
	
	private int weight;
	
	static String homePlanet;
	
	public Person(String name, int age, int weight)
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public Person()
	{
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
}

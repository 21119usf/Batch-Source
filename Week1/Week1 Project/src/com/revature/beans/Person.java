package com.revature.beans;

public class Person {
	// Code Blocks - {things between}
	//Instance Code Block
	{System.out.println("Im in an instance code block");}
	//Static Code Block
	static 	{System.out.println("Im in a static code block");}
	private String name;
	private int age, weight;
	static String homePlanet;
	//Constructors
	public Person(String name, int age, int weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public Person() {
		super();
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setWeight(int weight) {
		this.weight=weight;
	}
	public static String getHomePlanet() {
		return homePlanet;
	}
	public static void setHomePlanet(String homePlanet) {
		Person.homePlanet = homePlanet;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
}

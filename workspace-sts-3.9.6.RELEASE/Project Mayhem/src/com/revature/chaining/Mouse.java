package com.revature.chaining;

public class Mouse 
{
	private int numberOfTeeth;
	
	private int numberOFWhiskers;
	
	private int weight;
	
	public Mouse()
	{
		super();
	}
	
	public Mouse(int weight)
	{
		this(32, 50, weight);
	}
	
	public Mouse(int whiskers, int weight)
	{
		this(32, whiskers, weight);
	}
	
	public Mouse(int teeth, int whiskers, int weight)
	{
		this.numberOfTeeth = teeth;
		this.numberOFWhiskers = whiskers;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Mouse [numberOfTeeth=" + numberOfTeeth + ", numberOFWhiskers=" + numberOFWhiskers + ", weight=" + weight
				+ "]";
	}
	
	public static void main(String[] args)
	{
		Mouse mouse = new Mouse(3, 15);
		System.out.println(mouse);
	}
	
	
}

package com.revature.flows;

import java.util.Random;

public class Loops 
{
	public static void main(String[] args) 
	{
		whatColor("balls");
		
		Random rand = new Random();
		
		int number = rand.nextInt((19999 - 10000) + 1) + 10000;
		System.out.println(number);
	}
	
	static String color;
	
	public static void whatColor(String color)
	{
		switch (color)
		{
		case "green" : 
			System.out.println("green");
			break;
		
		case "purple" : 
			System.out.println("purple");
			break;
			
		case "crimson" : 
			System.out.println("crimson");
			break;
			
		default :
			System.out.println("Not a color");
		}
	}
	
}

package com.revature.driver;

import com.revature.beans.Person;

public class Driver 
{	
	public static void main(String[] args) 
	{
		Person a = new Person("Nick", 24, 180);
		
		Person b = new Person("Matt", 32, 265);
		
		Person c = new Person("Sloan", 23, 230);
		
		System.out.println(a.getName());
		
		System.out.println(b.getName());
		
		System.out.println(c.getName());
	}
}

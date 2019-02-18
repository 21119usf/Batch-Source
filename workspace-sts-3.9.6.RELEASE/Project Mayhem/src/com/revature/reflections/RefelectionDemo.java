package com.revature.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RefelectionDemo 
{
	/*
	 * A way for java to inspect itself at runtime.
	 * Can break encapsulation.
	 * Contains method for runtime inspection of objects.
	 * Class of object
	 * fields
	 * methods
	 * instructors
	 * includes private members.
	 * can modify or instantiate things, invoke methods, etc.
	 * java.lang.reflect
	 */
	public static void main(String[] args) 
	{
		try 
		{
			Class<?> c = Class.forName("java.awt.Dimension");
			
			System.out.println("Constructors: ");
			
			Constructor<?> con [] = c.getConstructors();
			
			for(int i = 0; i < con.length; i++)
			{
				System.out.println(" " + con[i]);
			}
			
			System.out.println("Fields: ");
			Field f[] = c.getFields();
			
			for(int i = 0; i < f.length; i++)
			{
				System.out.println(" " + f[i]);
			}
			
			System.out.println("Methods: ");
			Method m[] = c.getMethods();
			
			for(int i = 0; i < m.length; i++)
			{
				System.out.println(" " + m[i]);
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

}

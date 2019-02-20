package com.revature.classes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapStuffEX {


	
	public static HashMap<String, String> readFile(String filename) 
	{
		HashMap<String, String> customer = new HashMap<String, String>();
		try 
		{
		Scanner scanner = new Scanner(new File(filename));
			String line;
			while (scanner.hasNext())
			{
				line=scanner.nextLine();
				//this will be an epic loop someday
//				if (line.equals("")) 
//				{
//					
//				}
				String[] keyvalue = line.split(":");
				customer.put(keyvalue[0], keyvalue[1]);
			}
			scanner.close();
		} 
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return customer;
	}
	
	//hash allows only 2 things 
	//getting the name and password from the data.txt 
	public static String getNamePassword() 
	{
		HashMap<String, String> c = readFile("data.txt");
		return "Hello " + c.get("name") + "\nYour password is " + c.get("password");
	}
	
	public static String getNameAccountN() 
	{
		HashMap<String, String> c = readFile("data.txt");
		return "Welcome: " + c.get("name") + "\nAccount Number: " + c.get("accountNumber");
	}
	
	public static String getNameSSN() 
	{
		HashMap<String, String> c = readFile("data.txt");
		return c.get("name") + ", " + c.get("ssn");
	}

//	public static String getNamePassword() 
//	{
//		HashMap<String, String> c = readFile("data.txt");
//		return c.get("name") + ", " + c.get("password");
//	}


	
	//this info goes to BankingApplication or wherever.
	//reads the 2 values of getNamePassword. prints out name and password on text file
			//System.out.println(HashMapStuffEX.getNamePassword());
			//System.out.println(HashMapStuffEX.getNameSSN());	
	
	
	
	
	
	
}

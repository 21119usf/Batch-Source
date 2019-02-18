package com.revature.question20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/*
 Create a notepad file called Data.txt and enter the following:
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State

 */
public class QuestionTwenty {

	public static void main(String[] args) {
		//initialize input
		IO io = new IO();
		//convert entire input to string
		String inputData = io.readData();
		//convert the lines to an array of Strings using the line separator
		String[] dataLines = inputData.split(System.getProperty("line.separator"));
		//since Mickey is line 0, make it its own String
		String mickey = dataLines[0];
		//split the mickey String into an array by removing the ":" symbol
		String[] mickSplit = mickey.split(":");
		//first and second strings in the array are Mickey's name
		String name = mickSplit[0]+" " + mickSplit[1];
		//3rd is age
		int age = Integer.parseInt(mickSplit[2]);
		//...and 4th is his State
		String location = mickSplit[3];
		//display the three new Strings in the way it's desired above.
		System.out.println("Name: " + name);
		System.out.println("Age: " + age + " years");
		System.out.println("State: " + location + " State");
	}
	
	
}

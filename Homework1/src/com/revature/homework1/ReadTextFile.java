package com.revature.homework1;
import java.util.Scanner;


import java.io.File;
import java.io.FileNotFoundException;

public class ReadTextFile {

	/*
	 * The program takes and input file and reads it with scanner class
	 * and we have our scanner us a delimiter of ":" so it knows how much of the string to extract
	 * while more lines in the file exist, we scan the line and add each string delimited by the :
	 * and print it out to the console 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		File file = new File(".\\src\\com\\revature\\homework1\\Data.txt");
		try {
		Scanner kb = new Scanner(file);
		kb.useDelimiter(":");
		
		
		while (kb.hasNextLine()) {
			System.out.print("Name: " + kb.next()+ " ");
			System.out.println(kb.next());
			System.out.println("Age: " + kb.next());
			System.out.println("State" + kb.nextLine());
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}

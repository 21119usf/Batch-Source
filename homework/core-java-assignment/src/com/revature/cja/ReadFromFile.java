//Q20. Create a notepad file called Data.txt and enter the following:
//Mickey:Mouse:35:Arizona
//Hulk:Hogan:50:Virginia
//Roger:Rabbit:22:California
//Wonder:Woman:18:Montana
//Write a program that would read from the file and print it out to the screen in the
//following format:
//Name: Mickey Mouse
//Age: 35 years
//State: Arizona State

package com.revature.cja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFromFile {
	
	private static final String inFile = "Data.txt";
	
	// method to read content from file
	public String readInputStreamContents() {
		InputStream is = null;
		File file = new File(inFile);
		
		StringBuilder s = new StringBuilder();
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int b = 0;
		
		try {
			while ((b = is.read()) != -1) {
				char c = (char) b;
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return s.toString();
		
	}
	
	// method to format the string
	public void formatString(String str) {
		String[] formatMsg = str.split("\n");
		for (int i = 0; i < formatMsg.length; i++) {
			String[] eachLine = formatMsg[i].split(":");
			System.out.println("Name: " + eachLine[0] + " " + eachLine[1]);
			System.out.println("Age: " + eachLine[2] + " years");
			System.out.println("State: " + eachLine[3] + " State");
			System.out.println();
		}
	}

}

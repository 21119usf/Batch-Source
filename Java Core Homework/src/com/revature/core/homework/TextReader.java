package com.revature.core.homework;

import java.io.BufferedReader;
import java.io.FileReader;

// #20
public class TextReader {
	public static void parseDataFile() {
		String line = "";
		String name = "Name: ";
		String age = "Age: ";
		String state = "State: ";
		try {
			// open reader streams
			FileReader fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
			// read next line
			line = br.readLine();
			// loop while there is a next line
			while(line != null) {
				// split line by :
				String[] splitLine = line.split(":");
				// set name to first 2 elements
				name += splitLine[0];
				name += " ";
				name += splitLine[1];
				// set age to 3rd element
				age += splitLine[2];
				// set state to 4th element
				state += splitLine[3];
				System.out.println(name + " \n");
				System.out.println(age + "\n");
				System.out.println(state + "\n");
				name = "Name: ";
				age = "Age: ";
				state = "State: ";
				// read next line
				line = br.readLine();
			}
			// close stream
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TextReader.parseDataFile();
	}
}

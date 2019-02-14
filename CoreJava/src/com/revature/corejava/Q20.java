package com.revature.corejava;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Question 20 solution
public class Q20 {
	// Read file, parse and print
	public static void parseAndPrint(File f) throws Exception {
		Scanner sc = new Scanner(f);
		
		// Read from file, put each line into an ArrayList<String>
		List<String> sl = new ArrayList<String>();
		while (sc.hasNextLine()) {
			sl.add(sc.nextLine());
		}
		sc.close();
		
		// Parse each string and print
		for (String str : sl) {
			String[] tmp = str.split(":");
			System.out.println("Name: " + tmp[0] + " " + tmp[1]);
			System.out.println("Age: " + tmp[2]);
			System.out.println("State: " + tmp[3]);
			System.out.println();
		}
	}
	
	// Main
	public static void main(String[] args) {
		File f = new File("Q20.txt");
		try {
			parseAndPrint(f);
		} catch (Exception e) {
			System.out.println("ERROR: File not found");
		}
	}
}

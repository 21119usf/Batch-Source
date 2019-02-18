package com.revature.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
	
	public static void main(String[] args) {
		File file = new File("Data.txt");
		try {
			textPrint(file);
		}catch(Exception e) {
			System.out.println("File not found");
		}

	}
	
	public static void textPrint(File file) throws Exception {
		Scanner scan = new Scanner(file);
		List<String> s1 = new ArrayList<String>();
		while(scan.hasNextLine()) {
			s1.add(scan.nextLine());
		}
		scan.close();
		
		for(String str : s1) {
			String[] text = str.split(":");
			System.out.println("Name: " + text[0] + " " + text[1]);
			System.out.println("Age: "+ text[2] + " years");
			System.out.println("State: " + text[3] + " State");
			System.out.println();
		}
	}
	

}

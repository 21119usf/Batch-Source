package com.revature.homework1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q20_ReadFile {

	private String firstName;
	private String lastName;	
	private String  age;
	private String state;
	
	public Q20_ReadFile(String list) {
		String[] str = list.split(":");
		this.firstName = str[0];
		this.lastName = str[1];
		this.age = str[2];
		this.state = str[3];
	}
	public static void main(String[] args) {
		ArrayList<String> pplInfo = new ArrayList<String>();
		try {
			FileReader myFile = new FileReader("C:\\Users\\thoma\\Documents\\Week1\\Week1\\Data.txt");
			Scanner myScanner = new Scanner(myFile);
			while(myScanner.hasNext()) {
				pplInfo.add(myScanner.nextLine());
			}
			myScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			Q20_ReadFile f1 = new Q20_ReadFile(pplInfo.get(0));
			Q20_ReadFile f2 = new Q20_ReadFile(pplInfo.get(1));
			Q20_ReadFile f3 = new Q20_ReadFile(pplInfo.get(2));
			Q20_ReadFile f4 = new Q20_ReadFile(pplInfo.get(3));
			
			System.out.println("Name: " +  f1.firstName + " " + f1.lastName);
			System.out.println("Age: " +  f1.age);
			System.out.println("State: " +  f1.state);
			
			System.out.println("Name: " +  f2.firstName + " " + f2.lastName);
			System.out.println("Age: " +  f2.age);
			System.out.println("State: " +  f2.state);
			
			System.out.println("Name: " +  f3.firstName + " " + f3.lastName);
			System.out.println("Age: " +  f3.age);
			System.out.println("State: " +  f3.state);
			
			System.out.println("Name: " +  f4.firstName + " " + f4.lastName);
			System.out.println("Age: " +  f4.age);
			System.out.println("State: " +  f4.state);
	}

}

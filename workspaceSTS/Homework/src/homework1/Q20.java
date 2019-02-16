package homework1;

import java.io.*;
import java.util.ArrayList;

public class Q20 {
	//Create a notepad file called Data.txt and enter the following:
	//Mickey:Mouse:35:Arizona
	//Hulk:Hogan:50:Virginia
	//Roger:Rabbit:22:California
	//Wonder:Woman:18:Montana
	// 
	//Write a program that would read from the file and print it out to the
	//screen in the following format:
	// 
	//Name: Mickey Mouse
	//Age: 35 years
	//State: Arizona State

	public static ArrayList<String> fileToArrayList(String filename) {
		String[] lineList;
		ArrayList<String> fullList = new ArrayList<String>();
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				lineList = line.split(":");
				for (String s: lineList)
					fullList.add(s);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullList;
	}
	
	public static void formatPrint(ArrayList<String> s) {
		for (int i = 0; i < s.size(); i++) {
			if (i%4 == 0)
				System.out.print("Name: " + s.get(i) + " ");
			else if (i%4 == 1)
				System.out.println(s.get(i));
			else if (i%4 == 2)
				System.out.println("Age: " + s.get(i) + " years");
			else if (i%4 == 3)
				System.out.println("State: " + s.get(i) + " State\n");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> str = fileToArrayList("Data.txt");
		formatPrint(str);
		
	}
}

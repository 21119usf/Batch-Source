//our current package 
package core.java.core_questions;
//import class needed to make this work! 
import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class question20 {
	public static void main(String[] args) {
		//import file by typing the file's path
		File f = new File("src/core/java/extra_classes_interfaces/Data.txt");
		//try what to read the file 
		try {
		Scanner in = new Scanner(f);
		//if file exits then read first line of it
		String word = in.nextLine();
		//store first line of file in a String array
		String[] container = word.split(":"); //Split the string at ':'
		//close the scanner because we only need first line of the file
		in.close();
		//display info
		System.out.println("Name: " + container[0] + " " + container[1]);
		System.out.println("Age: " + container[2]);
		System.out.println("State: " + container[3]);
		//catch exceptions in case doesn't exit
		}catch(FileNotFoundException e) {
			e.printStackTrace(); 
		}catch(@SuppressWarnings("hiding") IOException e) {
			e.printStackTrace();
		}
	}
}

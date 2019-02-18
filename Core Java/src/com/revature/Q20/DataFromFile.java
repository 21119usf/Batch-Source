package com.revature.Q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataFromFile {

	static final String PATH = "src\\com\\revature\\Q20\\Data.txt"; //Specify PATH relative to source folder

	public static void main(String[] args) {
		Scanner in = null;											//Create new scanner and attempt to open file in try/catch
		try {
			in = new Scanner(new File(PATH));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!!");
			e.printStackTrace();
		}
		ArrayList<String> people = new ArrayList<String>();			//Create arrayList of string and populate from file
		while(in.hasNextLine()){
			people.add(in.nextLine());
		}
		in.close();													//Close console input stream
		ArrayList<Person> persons = createPeople(people);			//Create people from strings and store in ArrayList for person
		for(Person p : persons) {									//Print people
			System.out.println(p.toString());
		}
	}
	
	/*createPeople
	 *  Input	: ArrayList<String>
	 *  Output	: ArrayList<Person>
	 *  Algo	: First create ArrayList to hold multiple person. Then iterate
	 *  		  through people splitting each string by its attribute delimiter
	 *  		  ":". Call constructor to create new Person giving as attributes
	 *  		  elements of the split string that represented each person in proper
	 *  		  order. Add each person to the ArrayList of type person and return
	 *  		  that ArrayList.
	 */
	public static ArrayList<Person> createPeople(ArrayList<String> people) {
		ArrayList<Person> persons = new ArrayList<Person>();
		String[] peopleSplit;
		Person p;
		for(String s : people) {
			peopleSplit = s.split(":");
			p = new Person(peopleSplit[0],peopleSplit[1],Integer.parseInt(peopleSplit[2]),peopleSplit[3]);
			persons.add(p);
		}
		return persons;
	}
}

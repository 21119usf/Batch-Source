package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {
	
	public static void main(String[] args) {
		IO io = new IO();
		/* if output.txt does not exist, it will create it!
		 * If it doesn't exist, run it, and then refresh the project
		 * explorer to see it.
		 * 
		 */
		//io.writeOutputStreamContents("Lady Gaga");
		
		//Reading from a file
		System.out.println(io.readInputStreamContents());
		
		Person p1 = new Person ("Matt", 33, 265);
		Person p2 = new Person ("Jimmy", 36, 2650);
		Person p3 = new Person ("Veronica", 19, 126);
		
		
		IOWithCollections.personList.add(p1);
		IOWithCollections.personList.add(p2);
		IOWithCollections.personList.add(p3);
		
		IOWithCollections.writePersonFile();
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
		
	}
}

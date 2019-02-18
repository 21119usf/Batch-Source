package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {

	public static void main(String[] args) {
		IO io = new IO();
		/*If output.txt does not exist, it will create it!
		 * If it doesn't exist, run it, then refresh the project
		 * explorer to see it
		 */
//		String a = "banana";
//		io.writeOutputStreamContents("Lady Gaga"+a);
		
		//Reading from a file
			System.out.println(io.readInputStreamContents());
			

//			Person p1 = new Person("Matt", 133, 2650);
//			Person p2 = new Person("Jimmy", 136, 2650);
//			Person p3 = new Person("Veronica", 119, 1260);
//		
//			IOWithCollections.personList.add(p1);
//			IOWithCollections.personList.add(p2);
//			IOWithCollections.personList.add(p3);
//			IOWithCollections.writePersonFile();
//			IOWithCollections.readPersonFile();
//			System.out.println(IOWithCollections.personList.toString());
			
	}

}

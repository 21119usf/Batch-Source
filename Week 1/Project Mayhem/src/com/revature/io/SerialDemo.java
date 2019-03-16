package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {

	public static void main(String[] args) {
	IO io=new IO();
	/*if output.txt does not exist, it will create it!
	 * If it doesnt exist, run it, and then refresh the project
	 * explorer to see it
	 * 
	 */
	/*String a="Banana";
		io.writeOutputStreamContents("Lady Gaga"+a);*/
	//Reading from a file
		//System.out.println(io.readInputStreamContents());
	//IOWIthCollections.readPersonFile();
		Person p1=new Person("Matt",133,2650);
		Person p2=new Person("Jimmy",136,26500);
		Person p3=new Person("Veronica",119,1260);
		IOWIthCollections.personList.add(p1);
		IOWIthCollections.personList.add(p2);
		IOWIthCollections.personList.add(p3);
		
		IOWIthCollections.writePersonFile();
		IOWIthCollections.readPersonFile();
		System.out.println(IOWIthCollections.personList.toString());
		;
	}

}

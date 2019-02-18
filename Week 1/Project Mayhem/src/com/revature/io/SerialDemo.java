package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {
	IO io = new IO(); // If output.txt does not exit, it will create it!
	
	System.out.println(io.readInputStreamContents());
	
	Person p1 = new Person("Matt", 33,265);
	Person p2 = new Person("Matt", 33,265); 	
	Person p3 = new Person("Matt", 33,265); 
	
	IOWIthCollections.personList.add(p1);
	IOWIthCollections.personList.add(p2);
	IOWIthCollections.personList.add(p3);
	
	IOWithCollection.readPersonFile(); 
	System.out.println(IOWIthCollections.personList.toString());
	System.out.println(IOWIthCollections.personList.toString()); 
	
}

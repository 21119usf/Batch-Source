package com.revature.compare;

import java.util.Comparator;
	//Method 2 of comparing
	//External class that implements comparator
public class StudentComparator implements Comparator<Student>{
	//Compare GPAs
	
	@Override
	public int compare(Student o1, Student o2) {
		
		
		return (int)(o1.getGpa()-o2.getGpa());
	}

}

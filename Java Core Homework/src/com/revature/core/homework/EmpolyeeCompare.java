package com.revature.core.homework;

import java.util.Comparator;

import com.revature.core.homework.beans.Empolyee;
// #7
public class EmpolyeeCompare implements Comparator<Empolyee>{

	@Override
	public int compare(Empolyee o1, Empolyee o2) {
		// get score of name compare 
		int nameScore = o1.getName().compareToIgnoreCase(o2.getName());
		// get store of department compare
		int departmentScore = o1.getDepartment().compareTo(o2.getDepartment());
		// if name is the same check department
		if (nameScore == 0) {
			// if department is the same compare age
			if (departmentScore == 0) {
				if (o1.getAge() > o2.getAge()) {
					return 1;
				} else if (o2.getAge() > o1.getAge()) {
					return -1;
				} else {
					return 0;
				}
			} else {
				return departmentScore;
			}
		} else {
			return nameScore;
		}
	}
	
	public static void main(String[] args) {
		Empolyee a = new Empolyee("a", 1, "b");
		Empolyee b = new Empolyee("a", 2, "b");
		EmpolyeeCompare ec = new EmpolyeeCompare();
		
		System.out.println(ec.compare(a, b));
	}
	
}

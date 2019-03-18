package com.revature.assignment1;
import java.util.Comparator;

public class Q7Comparator implements Comparator<Q7Employee>{
	//this class implements the comparator interface from utilities
	@Override
	public int compare(Q7Employee o1, Q7Employee o2) {
		// TODO Auto-generated method stub
		return (int)(o1.geteID()-(o2).geteID());//comparing the employees id in order to sort them
	}

}

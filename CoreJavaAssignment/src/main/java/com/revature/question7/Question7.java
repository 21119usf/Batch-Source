package com.revature.question7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.question7.Worker;

public class Question7 {

	
	public static void main(String[] args) {
		//Sort two employees based on their name, department, 
		//and age using the Comparator interface.
		
		List<Worker> workerList = new ArrayList<Worker>();
		workerList.addAll(Arrays.asList(
				new Worker[] {
						new Worker("Matt", "Marketing", 26),
						new Worker("Sloan", "Design",  22),
				}));
		System.out.println("Original List: ");
		for(Worker w: workerList) {
			System.out.println(w);
		}
		System.out.println("====================");
		Collections.sort(workerList, (arg0, arg1)
				->{return arg0.getName().compareTo(arg1.getName());
				});
		System.out.println("Sorted by Name: ");
		for(Worker s: workerList) {
			System.out.println(s);
		}
		System.out.println("====================");
		Collections.sort(workerList, (arg0, arg1)
				->{return arg0.getDepartment().compareTo(arg1.getDepartment());
				});
		System.out.println("Sorted by Department: ");
		for(Worker s: workerList) {
			System.out.println(s);
		}
		System.out.println("====================");
		Collections.sort(workerList);
		System.out.println("Sorted by Age: ");
		for(Worker s: workerList) {
			System.out.println(s);
		}
		
		
	}
}

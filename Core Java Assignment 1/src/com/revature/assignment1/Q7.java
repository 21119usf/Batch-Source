package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.assignment1.Q7Employee;

public class Q7 {

	public static void main(String[] args) {
		
		List<Q7Employee> employeeList = new ArrayList<Q7Employee>();//arraylist to hold employee objects
		
		Q7Employee Eli = new Q7Employee(22, 8337, "Operations");//creating employee instances with age, id, and dept states
		Q7Employee Tiffani = new Q7Employee(37, 2134, "Finance");
		
		employeeList.add(Eli);//adding both objects to arralist
		employeeList.add(Tiffani);
		
		System.out.println("Original list");//demonstration of the list unordered
		for(Q7Employee s:employeeList) {//enhanced for loop to show
			System.out.println(s);
		}
		
		System.out.println("========================================");
		Collections.sort(employeeList);//demonstration of the list using comparable sorted by age
		System.out.println("Sorted by Age");
		for(Q7Employee s:employeeList) {
			System.out.println(s);
		}
		System.out.println("========================================");
		Collections.sort(employeeList, new Q7Comparator());//demonstration of the list using the comparator which was what the 
		System.out.println("Sorted by Employee ID");//what the problem was about
		for(Q7Employee s:employeeList) {
			System.out.println(s);
		}

	}


	
}



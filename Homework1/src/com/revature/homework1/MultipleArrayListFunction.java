package com.revature.homework1;

import java.util.ArrayList;

public class MultipleArrayListFunction {
	public static void makeArrayList(int x) {
		ArrayList<Integer> fullList = new ArrayList<Integer>();//create an arraylist the size of the number supplied as a parameter
		for(int i = 1;i <=x;i++) {
			fullList.add(i);
		}
		System.out.print("Original List: ");// we then output the list created from the process above
		System.out.println(fullList);
		System.out.println(" ");
		
		
		ArrayList<Integer> evenList = new ArrayList<Integer>(); //create a new arraylist to the hold the even numbers from the original arraylist
		
		System.out.print("Even List: ");
		int sumEven = 0;
		for(int i = 0;i<fullList.size();i++) {    //iterate through the array and if the number is even it is added to a running sum of just the
			     								//even numbers and prints out that array and the sum
			if(fullList.get(i) % 2 == 0) {
				sumEven += fullList.get(i);
				evenList.add(fullList.get(i));
			}
		}
		System.out.println(evenList);
		System.out.println("Even Total is: " + sumEven);//print out of even array and even number total
		System.out.println(" ");
		
		
		System.out.print("Odd List: ");
		int sumOdd = 0;
		ArrayList<Integer> oddList = new ArrayList<Integer>();
		for(int i = 0;i < fullList.size();i++) {//create a new arraylist that will search for the odd numbers and put them 
												//into an arraylist of their own. we then add the odd numbers up and display that total
			if(fullList.get(i) % 2 != 0) {
				sumOdd += fullList.get(i);
				oddList.add(fullList.get(i));
			}
		}
		System.out.println(oddList);
		System.out.println("Odd Total is: " + sumOdd); //displaying of the odd list and total
		System.out.println(" ");
		
		
		
		System.out.print("Non Prime list: ");//create another arraylist that goes through the orignial arraylist and uses a prime function from 
											// a class we created. if the number isnt prime it will be added to a list and output to the console
		ArrayList<Integer> noPrimes = new ArrayList<Integer>();
		for(int i = 0;i <fullList.size();i++) {
			if(!Array1to100.prime(fullList.get(i))) {
				noPrimes.add(fullList.get(i));
			};
		}
		System.out.println(noPrimes);
		}
	

	public static void main(String[] args) { //implementation of the class
		// TODO Auto-generated method stub
		MultipleArrayListFunction newList = new MultipleArrayListFunction();
		newList.makeArrayList(10);
		
	}

}

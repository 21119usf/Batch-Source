package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
	/*
	 * Iterator
	 * All of these implement the Iterable interface\only iterables 
	 * can be used in for each loops Interface, when implemented,
	 * allows the implementing type to be the subject of a for each loop
	 * Every collection already has an iterator, this allows traversal
	 * between elements and safe removal of elements in place.
	 */
	public static void main(String[] args) {
		// Create an arraylist
		ArrayList<String> a1 = new ArrayList<String>();
		//add elements
		a1.add("C");
		a1.add("D");
		a1.add("G");
		a1.add("B");
		a1.add("A");
		a1.add("F");
		a1.add("E");
		//use iterator to display contents of a1
		System.out.print("Original Contents of a1: ");
		Iterator<String> itr = a1.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();
		//Modify objects being iteratred
		ListIterator<String> litr = a1.listIterator();
		while(litr.hasNext()) {
			String element = litr.next();
			litr.set(element + "+");
		}
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		
		System.out.print("Modified Contents of a1: ");
		itr = a1.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();
		//Display the list backwards
		System.out.print("Modified list backwards: ");
		while (litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element + " ");
		}
	}

}

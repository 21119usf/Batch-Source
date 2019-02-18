package core.java.core_questions;

import java.util.ArrayList;
import java.util.Iterator;

public class question19 {
	public static void main(String[] args) {
		//fill our arraylist with number from 1 to 10
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			arr.add(i);
		}
		//create first iterator
		Iterator<Integer> all = arr.iterator();
		//display all the values from arraylist
		System.out.println("Display ArrayList: ");
		while(all.hasNext()) {
			int allIntegers = all.next(); 
			System.out.print("" + allIntegers + " ");
		}
		
		System.out.println();
		//create second iterator
		Iterator<Integer> even = arr.iterator();
		//display all the even values from arraylist
		System.out.println("Display even numbers from ArrayList");
		while(even.hasNext()) {
			int alleven = even.next(); 
			if(alleven%2 == 0) {
				System.out.print("" + alleven + " ");
			}
		}
		
		System.out.println();
		//create third iterator
		Iterator<Integer> odd = arr.iterator();
		//display all the odd values from arraylist
		System.out.println("Display odd numbers from ArrayList");
		while(odd.hasNext()) {
			int allodd = odd.next(); 
			if(allodd%2 != 0)
				System.out.print("" + allodd + " "); 
		}

		System.out.println();
		//create fourth iterator
		Iterator<Integer> prime = arr.iterator(); 
		//display all prime values from arraylist
		System.out.println("Display prime numbers from ArrayList");
		while(prime.hasNext()) { 
			//create flag to check prime numbers
			boolean isPrime = true;
			int allprime = prime.next();
			
			if(allprime == 1)
				continue; 
			
			for(int i = 2; i < allprime ; i++) {
				if(allprime % i == 0)
					isPrime = false; 
			}	
			//print all prime numbers 
			if(isPrime)
				System.out.print("" + allprime + " ");
		}
	}
}

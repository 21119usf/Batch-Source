package com.revature.question19;

import java.util.ArrayList;
import java.util.ListIterator;

public class Question19 {

	//Create an ArrayList and insert integers 1 through 10. 
	//Display the ArrayList. Add all the even numbers up and display the result. 
	//Add all the odd numbers up and display the result. 
	//Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();
		for(int i = 1; i < 11; i++) {
			numbers.add(Integer.valueOf(i));
		}
		
		System.out.println("All values in the ArrayList: " + numbers);
		
		//Add all the even numbers and display result
		ListIterator<Integer> litr = numbers.listIterator();
		while(litr.hasNext()) {

			Integer element = litr.next();
			if (element%2 == 0) {
				even.add(Integer.valueOf(element));
			}else {
				odd.add(Integer.valueOf(element));
			}
		}
		
		litr = even.listIterator();
		System.out.print("Sum of all even values in the ArrayList: ");
		int evenTotal = 0;
		while(litr.hasNext()) {
			Integer element = litr.next();
			evenTotal += element.intValue();
		}
		System.out.print(evenTotal);
		System.out.println();
		
		
		litr = odd.listIterator();
		System.out.print("Sum of all odd values in the ArrayList: ");
		int oddTotal = 0;
		while(litr.hasNext()) {
			Integer element = litr.next();
			oddTotal += element.intValue();
		}
		System.out.print(oddTotal);
		System.out.println();
		
		litr = numbers.listIterator();
		System.out.print("Removal of prime numbers from ArrayList: ");
		while(litr.hasNext()) {
			Integer element = litr.next();
			if(element == 1) {
				continue;
			}
			if(element == 2 || element == 3 || element%2 != 0 && element%3 != 0) {
				litr.remove();
			}
		}
		System.out.println(numbers);
	}

}

package com.revature.question19;

import java.util.ArrayList;
//importing the primeTester method I made for Question 9
import com.revature.question9.*;

/*
    Q19. Create an ArrayList and insert integers 1 through 10. 
    Display the ArrayList. Add all the even numbers up and display
    the result. Add all the odd numbers up and display the result. 
    Remove the prime numbers from the ArrayList and print out the 
    remaining ArrayList.
 */
public class QuestionNineteen {
			
	public static void main(String[] args) {
		//initializing the ArrayLists
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> primes = new ArrayList<>();
		//Populating the ArrayList
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		//getting the length of the ArrayList
		int length = list.size();
		//Displaying the ArrayList
		System.out.println(list);
		//Running the evenNum method
		evenNum(list, length);
		//Running the oddNum method
		oddNum(list, length);
		//creating a new instance of the QuestionNine class
		QuestionNine prime = new QuestionNine();
		//using the primeTester from QuestionNine class
		prime.primeTester(list, primes);
		//printing the primes ArrayList
		System.out.println(primes);
	}
	
	//odd sum method
	public static void oddNum(ArrayList<Integer> list, int length) {
		//initializing the sum at zero
		int sum = 0;
		for (int i = 0; i < length; i++) {
			//grabbing a test number from the ArrayList
			int testnum = list.get(i);
			//if the modulus is not zero, it's odd, if it's odd, we add the number to the sum
			if (testnum % 2 != 0) {
				sum = sum + testnum;
			}
		}
		System.out.println("Sum of Odd Numbers: " + sum);
	}
	
	//even sum method
	public static void evenNum(ArrayList<Integer> list, int length) {
		//initializing the sum at zero
		int sum = 0;
		for (int i = 0; i < length; i++) {
			//grabbing a test number from the ArrayList
			int testnum = list.get(i);
			//if the modulus is zero, it's even; if it's even, we add the number to the sum
			if (testnum % 2 == 0) {
				sum = sum + testnum;
			}
		}
		System.out.println("Sum of Even Numbers: " + sum);
	}

}

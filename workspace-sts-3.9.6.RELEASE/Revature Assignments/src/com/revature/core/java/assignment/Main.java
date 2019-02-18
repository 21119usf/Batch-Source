package com.revature.core.java.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.revature.core.java.assignment.helpers.Employee;
import com.revature.core.java.assignment.sorters.*;

public class Main {

	public static void main(String[] args) 
	{
		/*
		 * Question 1
		 */
		System.out.println("Q1 -------------------------\n");
		
		BubbleSort sorter = new BubbleSort();
		int[] arrayToBeSorted = {1,0,5,6,3,2,3,7,9,8,4};
		sorter.sort(arrayToBeSorted);
		for(int i : arrayToBeSorted)
		{
			System.out.println(i);
		}
		
		/*
		 * Question 2
		 */
		System.out.println("\nQ2 -------------------------\n");
		
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.displayFibonacciSequence(25);
		
		/*
		 * Question 3
		 */
		System.out.println("\nQ3 -------------------------\n");
		
		StringReverser stringReverser = new StringReverser();
		System.out.println(stringReverser.reverseString("some random words"));
		
		/*
		 * Question 4
		 */
		System.out.println("\nQ4 -------------------------\n");
		
		Factorial factorial = new Factorial();
		System.out.println(factorial.computeFactorial(4));
		
		/*
		 * Question 5
		 */
		System.out.println("\nQ5 -------------------------\n");
		
		Substring substring = new Substring();
		System.out.println(substring.getSubstring("Dictionary", 4));
		
		/*
		 * Question 6
		 */
		System.out.println("\nQ6 -------------------------\n");
		
		OddOrEven oddOrEven = new OddOrEven();
		System.out.println(oddOrEven.determineOddOrEven(5));
		
		/*
		 * Question 7
		 */
		System.out.println("\nQ7 -------------------------\n");
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("Nick", 24, "Software"));
		employeeList.add(new Employee("Toby", 32, "Human Recources"));
		employeeList.add(new Employee("Angela", 48, "Accounting"));
		employeeList.add(new Employee("Micheal", 45, "Management"));
		
		Collections.sort(employeeList, new SortEmployeeByName());
		
		for(Employee employee : employeeList)
		{
			System.out.println(employee.getName());
		}
		
		Collections.sort(employeeList, new SortByEmployeeAge());
		
		
		
		for(Employee employee : employeeList)
		{
			System.out.println(employee.getAge());
		}
		
		Collections.sort(employeeList, new SortByEmployeeDepartment());
		
		for(Employee employee : employeeList)
		{
			System.out.println(employee.getDepartment());
		}
		
		/*
		 * Question 8
		 */
		System.out.println("\nQ8 -------------------------\n");
		
		PalindromSeperator palindromeSeperator = new PalindromSeperator();
		
		ArrayList<String> randomWords = new ArrayList<String>();
		randomWords.add("karen");
		randomWords.add("madam");
		randomWords.add("tom");
		randomWords.add("civic");
		randomWords.add("radar");
		randomWords.add("jimmy");
		randomWords.add("kayak");
		randomWords.add("john");
		randomWords.add("refer");
		randomWords.add("billy");
		randomWords.add("did");
		
		ArrayList<String> palindromes = palindromeSeperator.seperatePalindromes(randomWords);
		
		for(String word : palindromes)
		{
			System.out.println(word);
		}
		
		/*
		 * Question 9
		 */
		System.out.println("\nQ9 -------------------------\n");
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++)
		{
			numbers.add(i);
		}
		
		PrimeNumberFinder primeFinder = new PrimeNumberFinder();
		
		ArrayList<Integer> primes = primeFinder.findPrimeNumbers(numbers);
		
		for(Integer prime : primes)
		{
			System.out.println(prime);
		}
		
		/*
		 * Question 10
		 */
		System.out.println("\nQ10 -------------------------\n");
		
		SmallestNumber smallestNumberFinder = new SmallestNumber();
		
		System.out.println(smallestNumberFinder.findSmallestNumber(11, 9));
		
		/*
		 * Question 11
		 */
		System.out.println("\nQ11 -------------------------\n");
		
		com.revature.core.java.assignment.floats.SomeFloats someFloats = 
				new com.revature.core.java.assignment.floats.SomeFloats(5.9f, 6.4f);
		
		System.out.println(someFloats.getFirstFloat() + " " + someFloats.getSecondFloat());
		
		/*
		 * Question 12
		 */
		System.out.println("\nQ12 -------------------------\n");
		
		EvenNumbers evenNumberfinder = new EvenNumbers();
		
		ArrayList<Integer> evenNumbers = evenNumberfinder.findEvenNumbers(numbers);
		
		for(Integer number : evenNumbers)
		{
			System.out.println(number);
		}
		
		/*
		 * Question 13
		 */
		System.out.println("\nQ13 -------------------------\n");
		
		TrianglePrinter trianglePrinter = new TrianglePrinter();
		
		trianglePrinter.printTriangle(4);
		
		/*
		 * Question 14
		 */
		System.out.println("\nQ14 -------------------------\n");
		
		System.out.println("Enter on of the following actions (sqrt, date, split): ");
		
		Scanner scanner = new Scanner(System.in);
		
		SwitchActions switchActions = new SwitchActions();
		switchActions.performAction(scanner.nextLine());
		
		/*
		 * Question 15
		 */
		System.out.println("\nQ15 -------------------------\n");
		
		DefinedArithmatic arithmatic = new DefinedArithmatic();
		
		System.out.println("Add 53 to 42");
		System.out.println(arithmatic.add(43, 52));
		
		System.out.println("Subtract 34 from 67");
		System.out.println(arithmatic.subtract(67, 34));
		
		System.out.println("Multiply 12 and 15");
		System.out.println(arithmatic.multiply(12, 15));
		
		System.out.println("Divide 17 by 3");
		System.out.println(arithmatic.divide(17.0, 3.0));
		
		/*
		 * Question 16
		 */
		System.out.println("\nQ16 -------------------------\n");
		
		StringCharacterCounter counter = new StringCharacterCounter();
		
		System.out.println("Please enter a String: ");
		System.out.println("The string contains " + counter.countCharacters(scanner.nextLine()) 
			+ " characters.");
		
		/*
		 * Question 17
		 */
		System.out.println("\nQ17 -------------------------\n");
		
		System.out.println("Enter your principle amount: ");
		double principle = scanner.nextDouble();
		
		System.out.println("Enter your rate: ");
		double rate = scanner.nextDouble();
		
		System.out.println("Enter the amount of time in months: ");
		int time = scanner.nextInt();
		
		InterestCalculator interestCalculator = new InterestCalculator();
		System.out.println("Your total interest is $" 
				+ interestCalculator.calculateInterest(principle, rate, time));
		
		/*
		 * Question 18
		 */
		System.out.println("\nQ18 -------------------------\n");
		
		StringChecker checker = new StringChecker();
		
		System.out.println("dooM returns " + checker.checkForUppercase("dooM"));
		System.out.println("sOfTwArE becomes " + checker.convertToUppercase("sOfTwArE"));
		System.out.println("Adding 10 to the String '20' gives " 
				+ arithmatic.add(10, checker.convertStringToInt("20")));
		
		/*
		 * Question 19
		 */
		System.out.println("\nQ19 -------------------------\n");
		
		ArrayListActions actions = new ArrayListActions(10);
		
		actions.displayArrayList();
		actions.addAllOdds();
		actions.removePrimes();
		
		/*
		 * Question 20
		 */
		System.out.println("\nQ20 -------------------------\n");
		
		FileReader fileReader = new FileReader();
		
		fileReader.readTextFromFile("/Users/Nick/Documents/workspace-sts-3.9.6.RELEASE/Revature Assignments/src/com/revature/core/java/assignment/Data.txt");
	}

}

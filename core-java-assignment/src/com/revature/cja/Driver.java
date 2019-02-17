// Driver class for CORE JAVA ASSIGNMENT
// Create one Java project for the homework with a separate class for each question, and use comments liberally in your code.

package com.revature.cja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


// package for question 11 (access two float-variables 
// from a class that exists in another package)
import com.revature.ep.OutsidePackage;;

public class Driver {
	
	// display int array
	public static void displayIntArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// function to print display message
	public static void printDisplayMsg(int questionNum, String questionMsg) {
		String msg = "Question " + questionNum + " (" + questionMsg + ")";
		String dashes = "";
		
		System.out.println(msg);
		
		for (int i = 0; i < msg.length(); i++) {
			dashes += "-";
		}
		
		System.out.println(dashes);
	}
	
	public static void displayIsUpperCase(boolean isUpperCase, String str) {
		if (isUpperCase) {
			System.out.println(isUpperCase + ", the String \"" + str + "\" does contain a uppercase!");
		} else {
			System.out.println(isUpperCase + ", the String \"" + str + "\" does NOT contain a uppercase!");
		}
	}
	
	// function to print display message with printed new line in front
	public static void printDisplayMsgNewLine(int questionNum, String questionMsg) {
		System.out.println();
		printDisplayMsg(questionNum, questionMsg);
	}

	// driver method
	public static void main(String[] args) {
		
		// Question 1
		printDisplayMsg(1, "Bubble Sort");		
		BubbleSort bs = new BubbleSort();		
		System.out.println("Before bubble sort: ");
		displayIntArr(bs.getArr());		
		bs.bubbleSort();
		System.out.println("After bubble sort: ");
		displayIntArr(bs.getArr());		
		
		// Question 2
		printDisplayMsgNewLine(2, "Fibonacci Numbers");
		System.out.println("The first 25 Fibonacci numbers beginning at 0 are:");		
		FibonacciNumbers fn = new FibonacciNumbers(25);
		fn.calcFibNums();
		displayIntArr(fn.getFibNumsArray());		
		
		// Question 3
		printDisplayMsgNewLine(3, "Substring");
		String exampleString = "Hello World";
		int idx = 8;
		System.out.println(new SubstringClass().substring(exampleString, idx));
		
		// Question 4
		printDisplayMsgNewLine(4, "Compute N Factorial");
		int factorialNum = 5;
		ComputeNFactorial cnf = new ComputeNFactorial(factorialNum);
		System.out.println(factorialNum + "! is: " + cnf.computeFactorial());
		
		// Question 5		
		
		// Question 6
		printDisplayMsgNewLine(6, "Is Integer Even");
		int five = 5, six = 6;
		IsIntegerEven iie = new IsIntegerEven();
		System.out.println(five + " is " + iie.isEven(five));
		System.out.println(six + " is " + iie.isEven(six));
		
		// Question 7
		printDisplayMsgNewLine(7, "Sort Two Employees");
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Joel", "Human Resources", 45));
		employeeList.add(new Employee("Billy", "Maintenance", 21));
		System.out.println("Unsorted List:");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println("Sorted by Name:");
		Collections.sort(employeeList, new SortEmployeeByName());
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println("Sorted by Department:");
		Collections.sort(employeeList, new SortEmployeeByDepartment());
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println("Sorted by Age:");
		Collections.sort(employeeList, new SortEmployeeByAge());
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		
		System.out.println();

		// Question 8
		printDisplayMsgNewLine(8, "Palindromes");
		Palindromes p = new Palindromes();
		p.addPalindromees();
		p.displayPalindromees();
		
		System.out.println();
		
		// Question 9
		printDisplayMsgNewLine(9, "Prime Numbers");
		System.out.println("Prime numbers between 1 and 100 are:");
		PrimeNumbers pn = new PrimeNumbers();
		pn.generateNumbers();
		pn.displayPrimeNumbers();		
		
		// Question 10
		printDisplayMsgNewLine(10, "Min Two Numbers Ternary");
		MinTwoNumbersTernary mtwt = new MinTwoNumbersTernary();
		int num1 = 3, num2 = 5;
		int min = mtwt.findMin(num1, num2);
		System.out.println("Minimum of " + num1 + " and " + num2 + " is " + min);
		
		// Question 11
		printDisplayMsgNewLine(11, "Packages");
		OutsidePackage op = new OutsidePackage();
		System.out.println("First float variable from a class that exists in another package: " + op.getFloat1());
		System.out.println("Second float variable from a class that exists in another package: " + op.getFloat2());
		
		// Question 12
		printDisplayMsgNewLine(12, "Print Even Numbers");		
		PrintEvenNumbers pen = new PrintEvenNumbers();
		pen.displayEvenNums();		
		
		// Question 13
		printDisplayMsgNewLine(13, "Display Triangle");
		DisplayTriangle dt = new DisplayTriangle();
		dt.displayTriangle();
		
		// Question 14
		printDisplayMsgNewLine(14, "Switch Case");
		SwitchCase sc = new SwitchCase();
		sc.switchCase(1);
		sc.switchCase(2);
		System.out.println("Split String:");
		sc.switchCase(3);
		
		// Question 15
		printDisplayMsgNewLine(15, "Interface with Simple Methods");
		SimpleMethodsClass sm = new SimpleMethodsClass();
		int num3 = 5, num4 = 10;
		System.out.println(sm.addition(num4, num3));
		System.out.println(sm.subtraction(num4, num3));
		System.out.println(sm.multiplication(num4, num3));
		System.out.println(sm.division(num4, num3));		
		
		// Question 16
		printDisplayMsgNewLine(16, "Number of Characters");
		System.out.println(new NumberOfChars().numOfChars(args[0]));		
		
		// Question 17
		printDisplayMsgNewLine(17, "Simple Interest");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter principal: ");
		double principal = Double.parseDouble(scanner.nextLine());
		System.out.print("Enter rate: ");
		double rate = Double.parseDouble(scanner.nextLine());
		System.out.print("Enter time: ");
		double time = Double.parseDouble(scanner.nextLine());
		System.out.println("Your Interest is: " + new InterestOnPrincipal().interest(principal, rate, time));		
		
		// Question 18
		printDisplayMsgNewLine(18, "Abstract Superclass, Concrete Subclass");
		ConcreteSubClass scs = new ConcreteSubClass();
		String helloWorld1 = "Hello World";
		String helloWorld2 =  "hello world";
		displayIsUpperCase(scs.isUppercase(helloWorld1), helloWorld1);
		displayIsUpperCase(scs.isUppercase(helloWorld2), helloWorld2);
		System.out.print("Enter a String to be uppercased: ");
		String inputString1 = scanner.nextLine();
		inputString1 = scs.toUppercase(inputString1);
		System.out.println("Here is your upper cased String: " + inputString1);
		System.out.print("Enter a integer that will be added to the number 10: ");
		int inputInt1 = Integer.parseInt(scanner.nextLine());
		inputInt1 = scs.addTen(inputInt1);
		System.out.println("Here if you int added with 10: "+ inputInt1);		
		
		// Question 19
		printDisplayMsgNewLine(19, "ArrayList Integers");
		System.out.println("ArrayList:");
		ArrayListIntegers ali = new ArrayListIntegers();
		ali.displayArrayList();
		System.out.println("\nSum of even nums: " + ali.sumEvenNumbers());
		System.out.println("Sum of odd nums: " + ali.sumOddNumbers());
		ali.removePrimeNumbers();
		System.out.println("Array List after removing Prime Numbers: ");
		ali.displayArrayList();
		
		System.out.println();
		
		// Question 20
		printDisplayMsgNewLine(20, "Read From File");
		ReadFromFile rff = new ReadFromFile();
		rff.formatString(rff.readInputStreamContents());
		
		scanner.close();
	}
}

package first.half;

/* Noel Gonzalez */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import beans.Employee;


//This class prints human readable results to the console, but does not contain implementation of answers
public class Driver {

	public static void main(String[] args) {
		
		//Q1
		System.out.println("Sorted Array:");
		Integer[] x = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort.sort(x);
		for(int i: x ) {
			System.out.print(i + " ");
		}
		System.out.println("");
		
		//Q2
		Fibonacci.fibonacciNumbers(25);
		
		//Q3
		String reverseStr = "Reverse this string!";
		System.out.println(reverseStr);
		System.out.println("Reversed string: " + ReverseString.reverseString(reverseStr));
		
		//Q4
		System.out.println("5! is equal to: " + Factorial.factorialOf(5));
		
		//Q5
		String start = "Full String";
		System.out.println(start);
		String result = Substring.getSubstring(start, 7);
		System.out.println("Only the first 7 chars: " + result);
		
		//Q6
		System.out.println("True or False:");
		System.out.println("8 is even: " + EvenOrNot.isEven(8));
		System.out.println("432431 is even: " + EvenOrNot.isEven(432431));
		
		//Q7
		System.out.println("Employee Sorting Section:");
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.addAll(Arrays.asList(
				
				new Employee[] {
						new Employee("Matt", "a", 55),
						new Employee("Sloan","b", 34),
						new Employee("Noel","hfa", 23),
						new Employee("David","ad", 23),
						new Employee("Freddie","ad",  1),
		}));
		
		
		Collections.sort(employeeList, new EmployeeComparatorByName());
		System.out.println("Sorted By Name:");
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println("==================================================");

		Collections.sort(employeeList, new EmployeeComparatorByDepartment());
		System.out.println("Sorted By Department:");
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println("==================================================");
		
		Collections.sort(employeeList, new EmployeeComparatorByAge());
		System.out.println("Sorted By Age:");
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println("==================================================");
		
		//Q8
		System.out.println("Check for Palimdromes:");
		System.out.println("Original:");
		
		String[] strarr = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> strarl = new ArrayList<String>();
		strarl.addAll(Arrays.asList(strarr));
		
		for(String str : strarl) {
			System.out.print(str + " ");
		}
		System.out.println("\nOnly Palimdromes:");
		
		ArrayList<String> palindromes = Palindromes.getPalimdromes(strarl);
		
		for(String str : palindromes) {
			System.out.print(str + " ");
		}
		
		//Q9
		System.out.println("\nPrime Numbers between 1-100");
		PrimeNumbers hundred = new PrimeNumbers(1, 100);
		hundred.printPrimeNumbers();
		
		//Q10
		System.out.println("\nThe minimum between 5 and 8 is: " + Minimum.minimumOf(5, 8));
		
		
	}

}

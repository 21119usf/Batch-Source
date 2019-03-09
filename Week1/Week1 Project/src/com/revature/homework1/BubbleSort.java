package com.revature.homework1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.revature.otherPackage.TwoFloats;

public class BubbleSort {
	public static void main(String[] args) {
		System.out.println("Question 1");
		BubbleSort bub = new BubbleSort();
		bub.sort(1,0,5,6,3,2,3,7,9,8,4);
		System.out.println("");
		System.out.println("Question 2");
		Fibonacci fib = new Fibonacci();
		fib.printOut(25);
		System.out.println("");
		System.out.println("Question 3");
		StringReverse sr = new StringReverse();
		sr.reverse("Go Noles!");
		System.out.println("Question 4");
		Factorial fac = new Factorial();
		fac.compute(5);
		System.out.println("Question 5");
		Substring sub = new Substring();
		System.out.println(sub.makeSubstring("KidCarries", 3));
		System.out.println("Question 6");
		Even evn = new Even();
		evn.evenCheck(44);
		System.out.println("Question 7");
		//Makes 2 employees to compare
		Employee emp1 = new Employee("Kid", "Lad", 99);
		Employee emp2 = new Employee("Aj", "Dude", 10);
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
        Collections.sort(empList, new Compare()); 
        //prints Employee List after comparisons
        for (Employee emp : empList) { 
            System.out.println(emp); 
        } 
		System.out.println("Question 8");
		Palindromes pal = new Palindromes();
		pal.makePalindromes();
		System.out.println("Question 9");
		Primes pr = new Primes();
		pr.printPrimes();
		System.out.println("");
		System.out.println("Question 10");
		Min min = new Min();
		min.findMin(87, 9);
		System.out.println("Question 11");
		GetFloats gf = new GetFloats();
		gf.getFloats();
		System.out.println("Question 12");
		Evens ev = new Evens();
		ev.printEvens();
		System.out.println("");
		System.out.println("Question 13");
		Triangle tri = new Triangle();
		tri.printTriangle();
		System.out.println("Question 14");
		MySwitch mySwitch = new MySwitch();
		mySwitch.makeSwitch(3);
		System.out.println("Question 15");
		MyCalculator calc = new MyCalculator();
		//Use all aspects of MyCalculator by passing in different values to its methods
		System.out.println(calc.addition(5, 7));
		System.out.println(calc.division(10, 5));
		System.out.println(calc.subtraction(14, 4));
		System.out.println(calc.multiplication(9, 11));
		System.out.println("Question 16");
		String input = args[0];
		//Gets string from command line and passes it to cl to find its length
		CommandLine cl = new CommandLine();
		cl.getCL(input);
		System.out.println("Question 17");
		//gets input from user by using Scanner class
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principal (integer)");
		int p = sc.nextInt();
		System.out.println("Enter the Rate of interest (integer)");
		int rate = sc.nextInt();
		System.out.println("Enter the number of years (integer)");
		int years = sc.nextInt();
		Interest interest = new Interest();
		interest.getInterest(p, rate, years);
		sc.close();
		System.out.println("Question 18");
		MySubclass mySub = new MySubclass();
		mySub.checkUpper("someString");
		mySub.convertLower("alotofLOWERCASE");
		mySub.convertString("54");
		System.out.println("Question 19");
		ArrayListManipulation arrManip = new ArrayListManipulation();
		arrManip.manipArrayList();
		System.out.println("Question 20");
		ReadFromFile rf = new ReadFromFile();
		try {
			rf.readFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sort(int... arr) {
		for (int i = 0; i<arr.length - 1; i++) {
			for (int j = 0; j<arr.length - i - 1; j++) {
				//compares value to next value and swaps if its greater than the next value
				if(arr[j]>arr[j+1]) {
					int swap = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = swap;
				}
			}
		}
		//prints out sorted array 
		for (int x:arr) {
			System.out.print(x + " ");
		}
	}
}
class Fibonacci {
	public void printOut(int num) {
		//initialize the sequence by providing the 2 initial values of 0 and 1
		int initVal0 = 0, initVal1 = 1;
		for(int i = 1; i <= num; i++) {
			System.out.print(initVal0 + " ");
			//sets nextVal to sum of previous two values
			int nextVal = initVal0 + initVal1;
			initVal0 = initVal1;  //moves initial values up to next value to continue sequence
			initVal1 = nextVal;
		}
	}
}
class Factorial{
	public void compute(int i){
		//Starts with sum at 1 since 1*n = n and sets the counter to the desired Factorial initially
		int sum = 1, counter = i;
		//multiplies the sum by the counter until the counter reaches 1
		while (counter != 1) {
			sum = sum*counter;
			counter--;
		}
		System.out.print(i+ "! = ");
		System.out.println(sum);
	}
}
class Evens{
	public void printEvens() {
		int arr[] = new int[100];//declares array with 100 values
		int i = 1;
		while (i<101) { //loop used to populate array
			arr[i-1]= i;
			i++;
		}
		//loops through recently populated array and prints evens
		for(int x : arr) {
			if(x%2== 0) {
				System.out.print(x+ " ");
			}
		}
	}
}
class Primes{
	public boolean primeCheck(int num) {
		int i;
	    for (i = 2; i <= num/2; i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	public void printPrimes() {
		int arr[] = new int[100];//declares array with 100 values
		int i = 1;
		while (i<101) { //loop used to populate array
			arr[i-1]= i;
			i++;
		}
		//loops through array and checks for prime using PrimeCheck
		for(int x : arr) {
			if(primeCheck(x) == true) {//if number is prime print it 
				System.out.print(x+ " ");
			}
		}
	}
}
class Even{
	public void evenCheck(int num) {
		float n = num;
		boolean evCheck = true;//starts with even check set to true (we assume 0 is even)
		for(int i = 0; i<num; i++) {//loops through alternating even and odd
			evCheck = !evCheck;
		}if (evCheck == true) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
			
		
	}
}
class Palindromes{
	public void makePalindromes() {
		ArrayList<String> original = new ArrayList<String>();
		original.add("karan");//populating original arrayList
		original.add("madam");
		original.add("tom");
		original.add("civic");
		original.add("radar");
		original.add("jimmy");
		original.add("kayak");
		original.add("john");
		original.add("refer");
		original.add("billy");
		original.add("did");
		//Creates StringBuilder to reverse and add to other array
		ArrayList<String> pals = new ArrayList<String>();
		for(int i = 0; i<original.size(); i++) {
			StringBuilder rev = new StringBuilder(original.get(i));
			pals.add(rev.reverse().toString());
		}
		//Prints both arrays
		System.out.println(original.toString());
		System.out.println(pals.toString());
	}
}
class Triangle{
	public void printTriangle() {
		//for loop to print triangle based on the row it prints the according pattern
		for(int i = 0; i<4; i++) {
			if(i == 3) {
				System.out.println("0 1 0 1");
			}if(i == 2) {
				System.out.println("1 0 1");
			}if(i == 1) {
				System.out.println("1 0");
			}if(i == 0) {
				System.out.println("0");
			}
		}
	}
}
class ArrayListManipulation{
	public void manipArrayList() {
		int evenSum = 0,oddSum = 0;
		//Loads array List with 1 - 10 for manipulation
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			arr.add(i);
		}
		//Goes through and adds the evens
		System.out.println(arr.toString());
		for (int i = 0; i<arr.size(); i++) {
			if(arr.get(i)%2== 0) {
				evenSum = evenSum + arr.get(i);
			}
		}
		//prints out even sum after loop
		System.out.println("Even sum is: " +evenSum);
		//Goes through and adds the odds
		for (int i = 0; i<arr.size(); i++) {
			if(arr.get(i)%2 != 0) {
				oddSum = oddSum + arr.get(i);
			}
		}
		//prints out the odd sum after loop
		System.out.println("Odd sum is: " + oddSum);
		//goes through loop and removes primes using checkPrime function
		for (int i = 0; i<arr.size(); i++) {
			if(checkPrime(arr.get(i)) == true ) {
				arr.remove(i);
			}
		}
		System.out.print("Removing Primes: ");
		System.out.println(arr.toString());
	}
	boolean checkPrime(int n) {
		if(n == 2) {
			return false;
		}else {
	        for(int i = 2; i < n; i++) {
	            if(n % i == 0)
	                return false;
	        }
		}
        return true;
	}   
}
class Employee {
	//Employee pojo used by comparator
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class Compare implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		//compare names
		int NameCompare = emp1.getName().compareTo(emp2.getName()); 
		//compare department
		int DepCompare = emp1.getDepartment().compareTo(emp2.getDepartment()); 
		//compare age (need to wrap int to Integer before)
		Integer a1 = new Integer(emp1.getAge());
		Integer a2 = new Integer(emp2.getAge());
        int AgeCompare = a1.compareTo(a2); 
        // 3-level comparison using if-else if- else block 
        if (NameCompare == 0 && DepCompare == 0) {
        	return ((AgeCompare == 0) ? DepCompare : AgeCompare);
        }
        else if (NameCompare == 0) { 
            return ((DepCompare == 0) ? NameCompare : DepCompare); 
        } else { 
            return NameCompare; 
        } 
	}
}
class StringReverse {
	//reverse string by looping and changing the substrings around as you go.
	public void reverse(String s) {
		 System.out.println(s);
		for (int i = 0; i < s.length(); i++) {
		    s = s.substring(1, s.length() - i)
		        + s.substring(0, 1)
		        + s.substring(s.length() - i, s.length());
		 }
		 System.out.println(s);
	}
}
interface Calculator {
	//Interface to implement methods
	int addition(int n1, int n2);
	int subtraction(int n1, int n2);
	int multiplication(int n1, int n2);
	int division(int n1, int n2);
}
class MyCalculator implements Calculator {
	//implements abstract methods from Calculator interface
	@Override
	public int addition(int n1, int n2) {
		System.out.print(n1 + " + " + n2 + " = ");
		return n1+n2;
	}

	@Override
	public int subtraction(int n1, int n2) {
		System.out.print(n1 + " - " + n2 + " = ");
		return n1-n2;
	}

	@Override
	public int multiplication(int n1, int n2) {
		System.out.print(n1 + " * " + n2 + " = ");
		return n1*n2;
	}

	@Override
	public int division(int n1, int n2) {
		System.out.print(n1 + " / " + n2 + " = ");
		return n1/n2;
	}
}
class Substring {
	//Makes a string and appends the string from start to the index
	String makeSubstring(String s, int index) {
		String sub = "";
		for (int i = 0; i< index; i++) {
			sub = sub + s.charAt(i);
		}
		return sub;
	}
}
class Min {
	void findMin(int num1, int num2) {
		//Finds min of 2 numbers using ternary opperator
		int min = num1<num2 ? num1:num2;
		System.out.println("The min between "+ num1 + " and " + num2 + " is: "+ min);
		 
	}
}
class GetFloats {
	void getFloats() {
		//gets floats from other package using getters.
		TwoFloats tf = new TwoFloats();
		System.out.println("The first float is: "+ tf.getF1()+" The second is: "+ tf.getF2());
		
	}
}
class MySwitch {
	void makeSwitch(int i) {
		switch(i) {
		case 1: 
			//switch statement using Math for the squareroot
			System.out.println("The square root of 25 is: "+ Math.sqrt(25));
			break;
		case 2:
			// switch statement using LocalDate for todays date
			System.out.println("Today's date is: " + LocalDate.now());
			break;
		case 3:
			// switch case to split String into a String Array
			String toSplit = "I am learning Core Java";
			System.out.println("Splitting the String: " + toSplit);
			String [] splitString = toSplit.split(" ");
			//Loops through array to print the split String
			for (int j = 0; j<splitString.length;j++) {
				System.out.println(splitString[j]);
			}
			break;
		}
	}
}
abstract class MyAbstract {
	//abstract class to implement
	abstract boolean checkUpper(String s);
	abstract String convertLower(String s);
	abstract void convertString(String s);
}
class MySubclass extends MyAbstract {
	//goes through String and checks in any characters are UpperCase
	@Override
	boolean checkUpper(String s) {
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(Character.isUpperCase(c) == true) {
				System.out.println("String "+ s + " contains an uppercase");
				return true;
			}
		}
		System.out.println("String "+ s + " does not contain an uppercase");
		return false;
		
	}
	// Goes through String and converts any lowercase to upper
	@Override
	String convertLower(String s) {
		String result = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(Character.isLowerCase(c) == true) {
				result = result + Character.toUpperCase(c);
			}else {
				result = result + c;
			}
		}
		System.out.println(result);
		return result;	
	}
	// Parses Int from string add 10 and prints result
	@Override
	void convertString(String s) {
		int result = Integer.parseInt(s) + 10;
		System.out.println("The result is: " + result);
	}
}
class Interest {
	// Calculates interest based on numbers inputed by user in command prompt
	void getInterest(int principal, int rateOfInt, int numOfYears) {
		System.out.println("The interest is : "+ principal*rateOfInt*numOfYears);
	}
}
class ReadFromFile {
	void readFromFile() throws Exception {
		  //reads from Data.txt
		  BufferedReader br = new BufferedReader(new FileReader("Data.txt")); 
		  String st; 
		  // Sets st to current Line 
		  while ((st = br.readLine()) != null) {
			//splits line into String array to concatenate at the end of the Strings
			String splitSt [] = st.split(":");
			String name = "Name: ";
			String age = "Age: ";
			String state = "State: ";
			name = name + splitSt[0] + " " + splitSt[1];
			age = age + splitSt[2] + " Years";
			state = state + splitSt[3]+ " State";
			//Prints out each aspect after concatenation per line
			System.out.println(name);
			System.out.println(age);
			System.out.println(state);
		  }
	} 
}
class CommandLine {
	void getCL(String s) {
		String input = s;
		System.out.println("The command line String: " + input + " is of length: " + input.length());
	}
}

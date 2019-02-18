package core.java.core_questions;

import java.util.Scanner;

public class question10 {
	//static method returning minimum of two numbers; 
	public static int find_minimum(int n1, int n2) {
		int min = n1 > n2 ? n2 : n1; //use ternary operator
		return min; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	System.out.println("Enter first Number: ");
	int n1 = in.nextInt(); 
	System.out.println("Enter Second Number: ");
	int n2 = in.nextInt();
	in.close();
	System.out.println("The minimum number was: " + find_minimum(n1,n2));
	}

}

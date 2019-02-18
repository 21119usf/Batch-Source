package core.java.core_questions;

import java.util.Scanner;
//import abstract class since is in another package 
import core.java.extra_classes_interfaces.abstractClass;

//This class extends abstractClass 
public class question18 extends abstractClass {
	
	public question18(){
		super(); 
	}
	//must override all abstract classes from abstractClass
	//method1
	//check uppercase characters 
	@Override
	public boolean m1_checkUpperCase(String n) {
		// TODO Auto-generated method stub
		for(int i = 0; i < n.length(); i++) {
			while(Character.isUpperCase(n.charAt(i)))
				return true; 
		}
		return false; 
	}
	//convert lowercase characters to uppercase 
	@Override
	public String m2_convertLowerToUpper(String n) {
		// TODO Auto-generated method stub
		String result = ""; 
		for(int i = 0; i < n.length(); i++) {
			result = result + Character.toLowerCase(n.charAt(i));
		}
	return result; 
	}
	//returns the sum of all the numeric values of the string's characters + 10; 
	@Override
	public int m3_convertStringToInt(String n) {
		// TODO Auto-generated method stub
		int num = 0; 
		for(int i = 0; i < n.length(); i++) {
			num = num + Character.getNumericValue(n.charAt(i)); 
		}
		num = num + 10; 
		return num;
	}
	//Appropriate main method to test above setup 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//enter the string 
		System.out.println("Enter String to be converted: ");
		String str = in.nextLine(); 
		
		question18 q = new question18(); 
		//print the result from first abstract method 
		System.out.println("Is there any uppercase in " + str + " ?");
		System.out.println("Result --> " + q.m1_checkUpperCase(str));
		System.out.println();
		//print the result from second abstract method 
		System.out.println("Convert all the lower cases to uppercase in " + str);
		System.out.println("Result --> " + q.m2_convertLowerToUpper(str));
		System.out.println();
		//print the result from third abstract method
		System.out.println("Add every single character value of " + str + " + 10");
		System.out.println("Result --> " + q.m3_convertStringToInt(str));
		System.out.println();
		//close scanner
		in.close();
	}
	
}

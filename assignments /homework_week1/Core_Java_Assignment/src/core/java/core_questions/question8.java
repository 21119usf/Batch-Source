//current package
package core.java.core_questions;
//import array list class
import java.util.ArrayList;
//create a class for question8
public class question8 {
	//create two arrayList fields
	/*
	 * 'a' is to store the regular string names
	 * 'b' is to store all the palindromes
	 * */
	ArrayList<String> a;
	ArrayList<String> b;
	//constructor 
	question8(ArrayList<String> a, ArrayList<String> b){ 
		this.a = a; 
		this.b = b; 
	}
	//this method stores the value of a String[] to an Array List
	public ArrayList<String> stores(String[] str) {
		this.a = new ArrayList<String>(); 
		for(String c : str) {
			this.a.add(c);
		}
	return this.a; 
	}
	//this method verifies if a string is a palindrome or not
	public boolean is_palindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
			while(start < end) {
				//if start and end character of the string don't match
				//then it not a palindrome
				if(s.charAt(start) != s.charAt(end))
					break;
				start++;
				end--;
			}
			//if start and end indexes are not equal or start > end
			//then is not a palindrome
			if(start >= end)
				return true; 
			else
				return false; 
	}
	//this method saves all palindromes in an array List
	public ArrayList<String> saves(String[] str) {
		this.b = new ArrayList<String>();
		for(String i : str) {
			if(is_palindrome(i)) {
				this.b.add(i);
			}
		}
	return this.b; 
	}
	
	//main method to print all the name mentioned below
	//Also to print all the name that are palindrome
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s1 = {"karen", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		
		ArrayList<String> stores = new ArrayList<String>(); 
		ArrayList<String> saves = new ArrayList<String>(); 
		
		question8 x = new question8(stores, saves);
		//this prints all the names
		for(String l : x.stores(s1)) {
			System.out.print(l + " ");
		}
		
		System.out.println();
		//this prints only palindromes
		for(String l1 : x.saves(s1))
			System.out.print(l1 + " ");	
	}

}

package com.revature.palindrome;

import java.util.ArrayList;

public class Palindrome {

	 ArrayList<String> a;
	    ArrayList<String> b;
	    
	    Palindrome(ArrayList<String> a, ArrayList<String> b){ 
	        this.a = a; 
	        this.b = b; 
	    }
	    public ArrayList<String> store(String[] str) {
	        this.a = new ArrayList<String>(); 
	        for(String c : str) {
	            this.a.add(c);
	        }
	    return this.a; 
	    }
	    
	    public boolean passedTest(String s) {
	        int start = 0;
	        int end = s.length() - 1;
	            while(start < end) {
	                if(s.charAt(start) != s.charAt(end))
	                    break;
	                start++;
	                end--;
	            }
	            
	            if(start >= end)
	                return true; 
	            else
	                return false; 
	    }
	    
	    public ArrayList<String> save(String[] str) {
	        this.b = new ArrayList<String>();
	        for(String i : str) {
	            if(passedTest(i)) {
	                this.b.add(i);
	            }
	        }
	    return this.b; 
	    }
	    
	    public static void main(String[] args) {
	    	System.out.println("Original Array: ");
	        String[] s1 = {"karen", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
	        
	        ArrayList<String> store = new ArrayList<String>(); 
	        ArrayList<String> save = new ArrayList<String>(); 
	        
	        Palindrome x = new Palindrome(store, save);
	    
	        for(String l : x.store(s1)) {
	            System.out.print(l + " ");
	        }
	        System.out.println(" ");
	        System.out.println("Palindrome Array: ");
	        
	        for(String l1 : x.save(s1))
	            System.out.print(l1 + " ");   
	    }
	}


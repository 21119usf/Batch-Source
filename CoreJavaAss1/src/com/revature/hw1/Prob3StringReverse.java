package com.revature.hw1;

public class Prob3StringReverse {
 
	//change input text option to console driven
	   public static void main(String args[])
	   {
		   //2 strings
	      String original = "This will be reversed", reverse = "";
	 
	      //length equals 7
	      int length = original.length();
	 
	      //i=6;true;6 becomes 5
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	    	  //"" = "" + position 21 to 20 to 19 etc.
	         reverse = reverse + original.charAt(i);
	 
	      System.out.println(reverse);
	   }
	}


package com.revature.hw1;

public class Prob8PalindromesArray {
	static public String[] nameList = new String[] 
			{"karan", 
			"madam", 
			"tom", 
			"civic", 
			"radar",
			"jimmy", 
			"kayak",
			"john",
			"refer",
			"billy",
			"did"};
	static public String[] palindromeList = new String[nameList.length];
	static public String[] reverseList = new String [11] ;
	static int counter = 0;
	
	public static void main(String args[]){
		//nameList length is 11
	for (int i = 0; i < nameList.length; i++) 
	{
		//appends each character in reverse
		String reverse = "";
	    for ( int j = nameList[i].length() - 1 ; j >= 0 ; j-- )
	    {
	    	//"" = "" + char position 
	    	//works
	        reverse = reverse + nameList[i].charAt(j);
	    }
	    //adds the reverse string to the reverselist array
	    reverseList[i] = reverse;
	    
	    if (nameList[i].equals(reverseList[i])) {
	    	//store the palindrome
	    	palindromeList[counter] = nameList[i];
	    	++counter;
	    }
	}
	
	//testing the reverse array
	
	for (int i = 0; i < palindromeList.length; i++) 
	{
		System.out.println(palindromeList[i]);	
	}
	}
	 
  	  
    
}

package com.revature.Q18;

public class Driver {

	public static void main(String[] args) {
		Inheritee i = new Inheritee();		//Create new Inheritee object
		String s1 = "the Empire state";		//Test string
		String s2 = "lorem ipsum";			//Another Test String
		System.out.println("'"+s1+"' Has uppercase: "+i.checkUpperCase(s1));	//Testing checkUpperCase true
		System.out.println("'"+s2+"' Has uppercase: "+i.checkUpperCase(s2));	//Testing checkUpperCase false
		System.out.println(i.toUpperCase(s1));									//Testing toUpperCase
		System.out.println("12 + 10 = "+i.convertStrToIntPlusTen("10"));		//Testing convert + 10

	}

}

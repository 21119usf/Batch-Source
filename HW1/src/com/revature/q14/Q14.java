package com.revature.q14;

import java.util.Date;

public class Q14 {

	public static void main(String[] args) {
		Date today = new Date();
		
		String check = "";
		String partOfString = "I am learning Core Java";
		
		for(int i = 0; i < 3; i++) {
			
			if(i == 0) {
				check = "j" ;
			}else if(i == 1) {
				check = "a";
			}else if(i == 2) {
				check = "v";
			}
			
			switch (check) {
			case "j":
				double num = 25;
				System.out.println("Square root of "+ num + " is " + Math.sqrt(num));
				break;
				
			case "a":
				String[] words = partOfString.split("\\s");//splits the string based on whitespace
				for(String w:words){  
					System.out.println(w);  
					} 
				break;
				
			case "v":
				System.out.println(today.toString());
				break;
			}
			
		}

	}

}

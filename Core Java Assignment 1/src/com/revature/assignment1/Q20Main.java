package com.revature.assignment1;


public class Q20Main {

	public static void main(String[] args) {
		Q20IO io = new Q20IO();
		
		String entireString = io.readInputStreamContents();
		
		splitAndDisplay(entireString);			
		}
	
	
	public static void splitAndDisplay(String s) {
			
		String[] splitted = s.split("\n");
		
		for(int i=0;i<splitted.length;i++) {
			String[] moreSplit = splitted[i].split(":");
			System.out.println("Name: "+moreSplit[0]+" "+moreSplit[1]+
								"\nAge: "+moreSplit[2]+" years"+
								"\nState: "+moreSplit[3].replaceAll("\\r\\n|\\r|\\n", "")+" state\n");
		}
	}	
}

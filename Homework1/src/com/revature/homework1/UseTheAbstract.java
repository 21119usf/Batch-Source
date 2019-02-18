package com.revature.homework1;

public class UseTheAbstract extends TheAbstract { //class will implement the abstract methods
	
	@Override
	public void containsUppercase(String input) { //method test if a string contains uppercase letters
												// we set the input as a normal string and take set the input at a 
												//variable with all lowercase letters, if the strings arent equal, 
												//we know the input had uppercase letters
		// TODO Auto-generated method stub
		String lower = input.toLowerCase();
		String normal = input;
		if(normal.equals(lower)) {
			System.out.println("Input String contains no uppercase letters");
		}else {
			System.out.println("Input String contains uppercase letters");
			
		}
	}

	@Override
	public void convertAllLower(String input) { //converts any lowercase letters to upper case
		/*
		 * method takes in a string input and stores each letter into a character array
		 * we then iterate through the array and if the letter at the current index is lowercase 
		 * we convert it to upper case and add it to our final string, if it is already uppercase
		 * it gets added as is to the string and the the string is output to the console
		 */
		// TODO Auto-generated method stub
		String finalbaby = "";
		char[] inputs = new char[input.length()];
		
		for(int i = 0;i < input.length();i++) {
			inputs[i] = input.charAt(i);}
		
		for(int j = 0;j< inputs.length;j++) {
			char tmp = inputs[j];
			//boolean tmp2 = Character.isLowerCase(tmp);
			if(Character.isLowerCase(tmp)) {
				finalbaby += Character.toUpperCase(tmp);
			}else {
				finalbaby += tmp;
			}
		}
		System.out.println(finalbaby);
	}

	@Override
	public void convertStringToInt(String input) { //takes in string literal of a number and converts it to type int
		// TODO Auto-generated method stub
		String theNumber = input;
		int asInt = Integer.parseInt(theNumber);
		int sum = 10 + asInt;
		System.out.println(sum);
	}

	public static void main(String[] args) {
		UseTheAbstract abs = new UseTheAbstract();
		abs.containsUppercase("String");
		abs.containsUppercase("string");
		abs.convertAllLower("String");
		abs.convertAllLower("Great");
		abs.convertStringToInt("10");
		abs.convertStringToInt("500");
		
		
	}

	
}

package com.revature.Q5;


public class SubString {

	public static void main(String[] args) {
		String str = "SubStringify me!!!<-cut this->";	//Create string to be subStringified
		String subStr = mySubString(str,18);			//call function to subStringify our string specified by index
		System.out.println(subStr);						//print

	}
	
	/*mySubString
	 * Input	: String, int
	 * Output	: String
	 * Algo		: Create char array from input string. Then create
	 * 			  char array for substring to be save. Loop through 
	 * 			  input char array int input number of times setting
	 * 			  our substring array to be equal to out input input
	 * 			  array. Finally return the substring array converted
	 * 			  to string
	 */
	public static String mySubString(String str, int idx) {
		char[] charStr = str.toCharArray();
		char[] subStr = new char[idx];
		for(int i=0; i<idx; i++) {
			subStr[i] = charStr[i];
		}
		return new String(subStr);
	}

}

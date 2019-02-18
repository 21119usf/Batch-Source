package com.revature.Q18;

public class Inheritee extends Inherited{
		
	public Inheritee() {
		super();
	}
	/*checkUpperCase
	 * Input	: String
	 * Output	: boolean
	 * Algo		: s is iterated over using a for loop and
	 * 			  the charAt function. If a char in the string
	 * 			  has a value between A and Z (inclusive) then 
	 * 			  true is returned. Else false
	 */ 
	@Override
	public boolean checkUpperCase(String s) {
		char c;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c >= 'A' && c <= 'Z')return true;
		}
		return false;
	}
	/*toUpperCase
	 * Input	: String
	 * Output	: String
	 * Algo		: s is converted to a char[]. If the char has
	 * 			  a value between a and z then 32 is added to it
	 * 			  to change it to an upper case equivalent. Then
	 * 			  the array is changed back to a string and returned  
	 */
	@Override
	public String toUpperCase(String s) {
		char[] charArr = s.toCharArray();
		for(int i = 0; i < s.length(); i++) {
			if(charArr[i]   >= 'a' && charArr[i] <= 'z')charArr[i] = (char)((int)charArr[i]-32); 
		}
		return new String(charArr);
	}
	/*convertStrToIntPlusTen
	 * Input	: String
	 * Output	: int
	 * Algo		: s is parsed then added to 10
	 */
	@Override
	public int convertStrToIntPlusTen(String s) {
		return Integer.parseInt(s) + 10;		
	}
}

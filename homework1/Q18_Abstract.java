package com.revature.homework1;

public abstract class Q18_Abstract {
	public abstract boolean checkUpperCase(String s);
	public abstract String toUpperC(String s);
	public abstract int toInt(String s);
	
	
	public static void main(String[] args) {
		

	}

}

class Q18_Class extends Q18_Abstract{

	@Override
	public boolean checkUpperCase(String s) {
		String str = s.toUpperCase();
		boolean bool = false;
		for(int i=0;i<s.length();i++){
			if(str.charAt(i) == s.charAt(i)) {
				bool = true;
				break;
			}
		}
		return bool;
	}

	@Override
	public String toUpperC(String s) {
		String str = s.toUpperCase();
		return str;
	}

	@Override
	public int toInt(String s) {
		try {
		int conversion = Integer.parseInt(s);
		return conversion;
		}catch(NumberFormatException e) {
			System.out.println("Error. Your string contains letters. Try numbers.");
			return 0;
		}
	}
	
}
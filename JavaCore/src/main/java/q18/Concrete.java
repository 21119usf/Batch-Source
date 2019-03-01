// David Lavoie Revature Assignment 1 Q19
package q18;

public class Concrete extends Air {

	String fu;
	
	@Override
	public boolean hasUpper(String subject) {
		for(int i = 0; i < subject.length(); i++) {
			Character c = subject.charAt(i);
			if (Character.isUpperCase(c) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpper(String subject) {
		String YELL = new String(); 
		for(int i = 0; i < subject.length(); i++) {
			Character c = subject.charAt(i);
			if (Character.isLowerCase(c)) {
				YELL += Character.toUpperCase(c);
			} else {
				YELL += c;
			}
		}
		return YELL;
	}

	@Override
	public int atoi10(String num) {
		int b = 10;
		num.trim();
		for(int i = 0; i < num.length(); i++) {
			b += Character.digit(num.charAt(i), 10)*Math.pow(10, num.length()-i-1);
		}
		System.out.println(b);
		return b;
		
	}
	
	public Concrete(String foo) {
		this.fu = foo;
	}
	
}

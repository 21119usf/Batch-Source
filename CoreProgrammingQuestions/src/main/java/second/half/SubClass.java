package second.half;

public class SubClass extends AbstractClass {
	
	private static SubClass instance;
	
	private SubClass() {
		
	}
	
	public static synchronized SubClass getInstance() {
		
		if(instance == null)
			instance = new SubClass();
		return instance;
	}

	@Override
	public boolean CheckUpperCase(String str) {
		char[] chararr = str.toCharArray();	
		for(char c : chararr) {
			if(Character.isUpperCase(c))
				return true;
		}
		return false;
	}

	@Override
	public String toUpperCase(String str) {
		char[] chararr = str.toCharArray();	
		for(int i = 0; i < chararr.length; i++) {
			chararr[i] = Character.toUpperCase(chararr[i]);
		}
		
		return String.valueOf(chararr);
	}

	@Override
	public int toInt(String str) { //unchecked
		int x = Integer.parseInt(str);
		return x + 10;
	}

}

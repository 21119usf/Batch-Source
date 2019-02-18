package homework1;
//creates abstract class to define methods
public abstract class Question18 {
	abstract void toUpper (String x);
	abstract void upperCheck(String n);
	abstract void changeInt (String d);
	

	public static void main(String[] args) {
		
		SubClassy w = new SubClassy();
		String j = "Take";
		String num = "11";
		//objects that use the methods from the subclass
		w.toUpper(j);
		w.upperCheck(j);
		w.changeInt(num);
		
	}
	
}

// sub class created to define methods
class SubClassy extends Question18{
	
	
	
	// changed inputed string to uppercase
	@Override
	 void toUpper(String x) {
		// TODO Auto-generated method stub
		String u = x.toUpperCase();
		System.out.println(u);
	}
	//checks to see if a string has an upper case by comparing it to itself
	@Override
	void upperCheck(String y) {
		// TODO Auto-generated method stub
		boolean v= !y.equals(y.toUpperCase());
		if(v){
			
			System.out.println("You have an upper case");
			
		}
	}

	@Override
	//changes a string number to a int by using the parse int method in the Integer class
	void changeInt(String h) {
		// TODO Auto-generated method stub
		int intz = Integer.parseInt(h);
		System.out.println(intz + 10);
	}	
	
}
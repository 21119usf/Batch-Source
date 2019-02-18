package homework1;

public class Question3 {

	static String stringReverse(String x){
		//Checks to see if the string array is empty if true returns the string 
		if (x.isEmpty()){
			return x;
		}
		//reverses the string through recursion
		else {
			return stringReverse(x.substring(1))+x.charAt(0);	
		}
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(stringReverse("Love"));
	}

}

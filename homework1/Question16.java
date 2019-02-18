package homework1;

public class Question16 {

	static void stringChar(String[] x) {
		int letterCount = 0;
		
		for(String s: x)
		{
		 letterCount += s.length();
			
		}
		System.out.println("Your String has this many characters: " + letterCount);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] y = {"chat","harold", "sing"};
		stringChar(y);
		
	}

}

package homework1;

public class Question5 {
	
	static void subString(String x, int b)
	{
		//converts string to char array
		char[] g = x.toCharArray();
		
		//runs a for loop to iterate through the array run until the inputed int value
		for(int v= 0; v< b; v++) {
			System.out.print(g[v]);
			
		}
			
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subString("Yellow", 3);
	}

}

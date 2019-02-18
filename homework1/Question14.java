package homework1;

public class Question14 {
	
	// method that switches case based on the integer in the argument
	static void caseTest(int x) {
		String z = "I am learning Core Java";
		int c = 9;
		
		switch(x) {
		// uses the math class method to calcuate the square root
			case 1: double n = Math.sqrt(c);
					System.out.println(n);
					break;
			// gets the current date from build in java method			
			case 2: System.out.println(java.time.LocalDate.now());
					break;
					
			// splits the string above by removing the spaces and stores it into an array		
			case 3: 
				
					
					
					String[] splits = z.split(" ");
					for(String k : splits)
					{
						System.out.print(k);
					}
					
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		caseTest(1);
		caseTest(2);
		caseTest(3);
		
	}
}

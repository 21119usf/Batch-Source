package homework1;

public class Question2 {

	static int fibNumbers(int fib)
	{
	
		int fibStore[] = new int[fib+2];
			int z;
			fibStore[0] = 0;
			fibStore[1] = 1;
		
		
			
			for (z = 2; z<=fib; z++)
		{
			fibStore[z] = fibStore[z-1] + fibStore[z-2];
			
		}
		
		return fibStore[fib];
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int n = 25;
				 
	        
	        for(int t1= 0; t1 <= n; t1++)
	        {
	           fibNumbers(t1);
	           System.out.println(fibNumbers(t1));
	        }
		
	}

}

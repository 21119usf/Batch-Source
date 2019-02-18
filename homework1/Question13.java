package homework1;



public class Question13 {
	
	  static void trianglePrint() 
	    { 
		  //creates an array to hold numbers 
		  
		  int[] x = {1,0,1,0,1,0,1,0,1,0,1};
		  // used this array first it prints the opposite 1, 01, 101, etc.
		  //int[] x = {0,1,0,1,0,1,0,1,0,1,0};
		 
	      
	        int i= 0;
	        //nested for loop iterates the array and prints out the value at that arrays based on the equation for variable d
	        for(i=0; i<x.length; i++) 
	        { 
	            for(int k=1;k<i;k++){
	            	int d = (x[i]+x[k]) %2;
	                System.out.print(x[d]);
	               
	                } 
	            // ending line printed after each row 
	            System.out.println(); 
	        } 
	    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trianglePrint();
		
	}

}

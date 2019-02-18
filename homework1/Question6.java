package homework1;

public class Question6 {
	//Some how my wonky math worked on this. 
 static void isEven(int x) {
	 //basically why this works if you divide an odd number you will get a remainder which is not 
	 // equal to a whole number integer. 
	 // this method does not work with a double because it is too precise
 	if(x/2 != x*.5)
 	{
 		System.out.println("You have an odd number");
 	}
 	else 
 	{
 		System.out.println("You have an even number");
 	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isEven(17);
		isEven(18);
	}

}

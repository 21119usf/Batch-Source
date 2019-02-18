package homework1;

interface maths {
	  void addition(int a, int b);
	  void multi(int a, int b);
	  void subtr(int a, int b);
	  void divide(int a, int b);
	  
	  
		
	}
	

public class Question15 implements maths{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question15 b = new Question15();
		b.addition(3,4);
		b.multi(3,4);
		b.subtr(3,4);
		b.divide(12,4);
	}

	@Override
	public void addition(int a, int b) {
		// TODO Auto-generated method stub
		 int n =a+b;
		 System.out.println("Your added number is: " + n);
	}

	@Override
	public void multi(int a, int b) {
		// TODO Auto-generated method stub
		 int n =a*b;
		 System.out.println("Your multiplied number is: " + n);
	}

	@Override
	public void subtr(int a, int b) {
		// TODO Auto-generated method stub
		 int n =a-b;
		 System.out.println("Your subtracted number is: " + n);
	}

	@Override
	public void divide(int a, int b) {
		// TODO Auto-generated method stub
		 int n = Math.floorDiv(a, b);
		 System.out.println("Your divided number is: " + n);
	}

}

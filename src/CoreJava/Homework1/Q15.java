package com.revature.homework;

public class Q15 {

	public static void main (String args[]) 
	{
		Son obj = new Son();
		obj.disp();
		
	}
}
class Father
{
	int a = 10;
	int add(int y)
	{
		int b = y;
		return (a+b);
	}
}
interface Mother
{
	int c = 30;
	void disp();
}

class Son extends Father implements Mother {
	int m = a * Mother.c;
	int sum = add(20);
	int sub = a - Mother.c;
	int div = a / Mother.c;
	public void disp()
	{
	System.out.println("Addition = "+sum);
	System.out.println("Multiplication = "+m);
	System.out.println("Subtraction = "+sub);
	System.out.println("Division = "+div);
	}
}

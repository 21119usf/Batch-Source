package marquez.revature.q1;

public class BubbleSort 
{
	public static void bubbleSort(int[]x)
	{
		boolean flag = true;
		int temp;
		int times = x.length-1;
		//while loop to sort the data using a Bubble Sort method
		//while(flag==true) (alternate code of doing it)
		while (flag) 
		{
			flag = false;
			//for (int j=0; j<x.length-1; j++) (alternate code of doing it)
			for (int j=0;j<times; j++)
			{
				if (x[j] > x [j+1])
				{
					temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
					flag = true;
				}
			}
			times--;
		}
	}
	public static void main(String[] args)
	{
		//x holds an array of int variables
		int x[] = {1,0,5,6,3,2,3,7,9,8,4};
		//calls bubbleSort method
		bubbleSort(x);
		//loops and prints the x at index i
		for(int i = 0; i<x.length;i++)
		{
			System.out.println(x[i]);
		}
	}
}

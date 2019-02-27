package bankdata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writers {

	public static void fileWrites (ArrayList<String> x)
	{
		 FileWriter writer = null;
		try {
			writer = new FileWriter("customer.txt",true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 for(String str: x) {
	
		   try {
			writer.write(str + ":");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  
		 }
		 try {
			writer.write("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

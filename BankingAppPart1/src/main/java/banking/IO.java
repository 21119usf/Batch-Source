package banking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IO {
	
	public static <T> void writeFile(String fileName, ArrayList<T> obarr) {
		try {		
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(fileName));
			objectOut.writeObject(obarr);
			objectOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked") //broken
	public static <T> ArrayList<T> ReadFile(String fileName, ArrayList<T> ob) {
		
		ArrayList<T> newarr = new ArrayList<T>();
		
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(fileName));
		    newarr = (ArrayList<T>) objectIn.readObject();
			objectIn.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return newarr;
	}
}

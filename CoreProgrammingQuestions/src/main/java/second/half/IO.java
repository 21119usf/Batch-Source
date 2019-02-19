package second.half;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IO {
	
	public static String readFromFile() {
		InputStream is = null;
		File file = new File("Data.txt");
		StringBuilder s = new StringBuilder();
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int b = 0;
		try {
			while((b = is.read()) != -1) {
				char c = (char) b;
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		s.toString().split(":");
		return s.toString();
	}
	
	public static void printFromFile() {
		String[] input = readFromFile().replace("\r", "").replace("\n", ":").split(":"); //removes windows line breaks
		
		
		for(int i = 0; i < input.length - 4; i+=4) {
			System.out.println("Name: " + input[i] + " " + input[i + 1]);
			System.out.println("Age: " + input[i+ 2]);
			System.out.println("State: " + input[i + 3] + " State");
		}
	}

}

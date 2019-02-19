// David Lavoie Revature Assignment 1 Q20
package q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 

public class FileFormatting {
	

	public static void main(String[] args) throws IOException {
		
		ArrayList<Person> fu = new ArrayList<Person>();
		FileReader fr;
		try {
			fr = new FileReader("C:\\Users\\My DELL\\Documents\\workspace-sts-3.9.6.RELEASE\\CoreJavaAssignment1\\src\\HW_appendix\\Data.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) 
	        {
	            fu.add(new Person(br.readLine()));
	        }
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(Person person: fu) {
			System.out.println("Name " + person.name1 + " " + person.name2);
			System.out.println("Age: " + person.age +" years");
			System.out.println("State: "+ person.state + " State");
		}
	}

}

// I made a person class and included a constructor with a 1 line argument, wherein that line follows the
// specific format of the Data.txt file as prescribed.
class Person {
	String name1, name2, state;
	int age;
	
	public Person(String line) {
		String[] args = line.split(":");
		this.name1 = args[0];
		this.name2 = args[1];
		this.age = Integer.parseUnsignedInt(args[2]);
		this.state = args[3];
		
	}

}

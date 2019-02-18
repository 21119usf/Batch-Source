package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question20S {

	
	@SuppressWarnings("resource")
	public  void readFiler() {
		
		try {
           

            Scanner input = new Scanner("Data.txt");

            File file = new File(input.nextLine());

            input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                
                
                
                //System.out.println("Name: " +"Age "+line );
                System.out.println(line);
            }
           
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question20S hup = new Question20S ();
		
		hup.readFiler();
		
	}

}

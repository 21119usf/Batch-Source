package homework1;

import java.util.ArrayList;
import java.util.List;

 
 
public class Question8 {
// creates a class to run palindrome method
	static class  PalinStore
 {
// method that takes a list as an argument
	static void paladin(List<String> arrayStore)
	{
	// Gets the array size to interate then converts the list to string array
		int z = arrayStore.size();
		String[] y = arrayStore.toArray(new String[0]);
		// second list to store palindromes in
		List<String> arrayStore2 = new ArrayList<String>();
		System.out.println("Testing for Palindromes: ");
		for(int v = 0; v< z; v++)
		{
			 String palSearch = new StringBuffer(y[v]).reverse().toString(); 
			  
			    // checks for palindrome
			    if (y[v].equals(palSearch)) {
			      System.out.println("Palindrome Added"); 
			    
			    arrayStore2.add(palSearch);
			   
			    }
			    else
			    {
			      System.out.println("No Palindrome Match");
			     
			    } 
			    
		}
		// prints 2nd Palindrome List
		System.out.println("Your Palindrome List: ");
		System.out.println(arrayStore2.toString());
	}
	 
 }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    List<String> arrayStore = new ArrayList<String>();
	    
	    arrayStore.add("karan");
	    arrayStore.add("madam");
	    arrayStore.add("tom");
	    arrayStore.add("civic");
	    arrayStore.add("radar");
	    arrayStore.add("jimmy");
	    arrayStore.add("kayak");
	    arrayStore.add("john");
	    arrayStore.add("refer");
	    arrayStore.add("billy");
	    arrayStore.add("did");
	    
	    System.out.println("Your Original List: ");
	    System.out.println(arrayStore.toString());
	    PalinStore.paladin(arrayStore);
	}

}

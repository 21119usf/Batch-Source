package core.java.extra_classes_interfaces;
//import classes
import java.util.Comparator;
import core.java.core_questions.*;
//class to have a comparator method which compares age field from question7
public class SortByAge_question7 implements Comparator<question7> {
	//override compare method
	@Override
	public int compare(question7 o1, question7 o2) {
		// TODO Auto-generated method stub
		//return ages in ascending order
		return o1.age - o2.age;
	}
	
}

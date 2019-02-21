package core.java.extra_classes_interfaces;
//import Comparator interface
import java.util.Comparator;
//import question7 class
import core.java.core_questions.question7;

//class to have a comparator method which compares name field from question7
public class SortByName_question7 implements Comparator<question7> {
	//override compare method
	@Override
	public int compare(question7 o1, question7 o2) {
		// TODO Auto-generated method stub
		//sort names in ascending order
		return o1.name.compareTo(o2.name);
	}
}

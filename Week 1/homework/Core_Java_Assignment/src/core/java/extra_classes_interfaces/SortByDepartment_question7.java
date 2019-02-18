package core.java.extra_classes_interfaces;
//import Comparator interface and question7 class
import java.util.Comparator;
import core.java.core_questions.*;

//class to have a comparator method which compares department field from question7
public class SortByDepartment_question7 implements Comparator<question7> {
	//override compare method
	@Override
	public int compare(question7 o1, question7 o2) {
		// TODO Auto-generated method stub
		//sort departments in ascending order
		return o1.department.compareTo(o2.department);
	}
}

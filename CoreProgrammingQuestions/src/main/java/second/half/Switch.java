package second.half;

import java.util.Calendar;

public class Switch {
	
	public static void SwitchCase(String casearg) {
		
		switch(casearg) {
		case "root":
			System.out.println("root of 10 is: " + Math.pow(10, 0.5));
			break;
		case "date":
			System.out.println(Calendar.getInstance().getTime());
			break;
		case "string":
			String[] strar = "I am learning Core Java".split(" ");
			for(String str : strar) {
				System.out.print(str+ " ");
			}
			System.out.println();
			break;
		}
		
			
		
	}

}

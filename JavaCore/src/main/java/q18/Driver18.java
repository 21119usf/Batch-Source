// David Lavoie Revature Assignment 1 Q19
package q18;

public class Driver18 {

	public static void main(String[] args) {
		Concrete yes = new Concrete("Yes, Dear!");
		Concrete no = new Concrete("no thanks.");
		System.out.println(yes.hasUpper(yes.fu));
		System.out.println(yes.toUpper(no.fu));
		System.out.println(yes.atoi10("19"));
	}

}

// David Lavoie Revature Assignment 1 Q13
package q13;

public class Triangle {
	
	// I dislike this patterning personally.
	static void makeTriangle(int h) {
		char next = '0';
		for(int i = 0; i < h; i++) {
			String line = "";
			for(int j = -1; j < i; j++) {
				line+= next;
				line+= ' ';
				if(next == '0') {
					next = '1';
				} else {
					next = '0';
				}
			}
			System.out.println(line);
		}
	}
	public static void main(String[] args) {
		makeTriangle(4);

	}

}

package homework1;
//DONE
public class Q13 {
	//Display the triangle on the console as follows using any type of loop.
	//Do NOT use a simple group of print statements to accomplish this.
	//0
	//1 0
	//1 0 1
	//0 1 0 1
	
	/*
	 * I keep a string saved that is appended to each iteration
	 */
	public static void printTri(int layers) {
		String startingString = "";
		String stringToAdd = "0";
		for (int i = 0; i < layers; i++) {
			if (i == 0) { //print the initial layer
				startingString = "0";
				System.out.println(startingString);
				continue;
			}
			if (i%2 == 1) { //if we are on an even layer, change the string to append
				if (stringToAdd.equals("0"))
					stringToAdd = "1";
				else
					stringToAdd = "0";
				startingString = stringToAdd + " " + startingString; //append my string on the left
			}
			if (i%2 == 0) {
				startingString = startingString + " " + stringToAdd; //append my string on the right
			}
			System.out.println(startingString); //print layer
		}
	}
	
	public static void main(String[] args) {
		printTri(4);
	}
}

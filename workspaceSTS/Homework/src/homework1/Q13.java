package homework1;
//DONE
public class Q13 {
	//Display the triangle on the console as follows using any type of loop.
	//Do NOT use a simple group of print statements to accomplish this.
	//0
	//1 0
	//1 0 1
	//0 1 0 1
	public static void printTri(int layers) {
		String startingString = "";
		String stringToAdd = "0";
		for (int i = 0; i < layers; i++) {
			if (i == 0) {
				startingString = "0";
				System.out.println(startingString);
				continue;
			}
			if (i%2 == 1) {
				if (stringToAdd.equals("0"))
					stringToAdd = "1";
				else
					stringToAdd = "0";
				startingString = stringToAdd + " " + startingString;
			}
			if (i%2 == 0) {
				startingString = startingString + " " + stringToAdd;
			}
			System.out.println(startingString);
		}
	}
	
	public static void main(String[] args) {
		printTri(4);
	}
}

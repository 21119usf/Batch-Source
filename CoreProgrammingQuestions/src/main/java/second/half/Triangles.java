package second.half;

public class Triangles {
	
		
		public static void printTriangleFromArray(int[][] arr) {
			
			for(int[] i: arr) {
				for(int j: i) {
					System.out.print(j + " ");
				}
				System.out.println("");
			}
		}
}

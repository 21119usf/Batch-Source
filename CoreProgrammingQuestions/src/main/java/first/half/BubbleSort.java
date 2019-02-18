package first.half;

public class BubbleSort {
	
	//single iteration bubble sort
	public static <E extends Comparable<E>> E[] sort(E[] array){
		
		E temp;
		boolean sorted = false;
		
		
		while(sorted == false) {
			sorted = true;
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i].compareTo(array[i + 1]) > 0) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
					
			}
		}
		return array;
	}

}

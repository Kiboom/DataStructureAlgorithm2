package merge_sort;

public class SortChecker {

	public static void isSorted(int[] array){
		for(int i=0 ; i<array.length-1 ; i++){
			if(array[i] > array[i+1]){
				System.out.println("  --> Not Sorted!");
				return;
			}
		}
		System.out.println("  --> Sorted!");
	}
	
}

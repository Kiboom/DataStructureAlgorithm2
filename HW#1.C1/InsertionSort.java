package insertion_sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array0 = {};
		int[] array1 = {1};
		int[] array2 = {1,2};
		int[] array3 = {2,1};
		int[] array4 = {1,1};
		int[] array5 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] array6 = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] array7 = {1,3,5,9,8,11,14,15,17,12,4,2,7,10,13,16,20,18,6,19};
		int[] array8 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		insertionSort(array0);
		insertionSort(array1);
		insertionSort(array2);
		insertionSort(array3);
		insertionSort(array4);
		insertionSort(array5);
		insertionSort(array6);
		insertionSort(array7);
		insertionSort(array8);

		isSorted(array0);
		isSorted(array1);
		isSorted(array2);
		isSorted(array3);
		isSorted(array4);
		isSorted(array5);
		isSorted(array6);
		isSorted(array7);
		isSorted(array8);
	}

	public static int[] insertionSort(int[] array){
		if(array.length <= 0){
			System.out.println("null");
			return null;
		}
		for(int i=1 ; i<array.length ; i++){
			int sortingKey = array[i];
			int prePos = i-1;
			while(prePos >= 0 && array[prePos]>sortingKey){
				array[prePos+1] = array[prePos];
				prePos--;
			}
			array[prePos+1] = sortingKey;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	public static int isSorted(int[] array){
		for(int i=0 ; i<array.length-1 ; i++){
			if(array[i] > array[i+1]){
				System.out.println("오름차순으로 정렬되어있지 않습니다.");
				return 0;
			}
		}
		System.out.println("오름차순으로 정렬되어있습니다.");
		return 1;
	}
}

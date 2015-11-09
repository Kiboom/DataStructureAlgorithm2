package merge_sort;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		
		int[] arr0 = {};
		int[] arr1 = {1};
		int[] arr2 = {1,3};		
		int[] arr3 = {3,1};		
		int[] arr4 = {3,3};
		int[] arr5 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] arr6 = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] arr7 = {1,3,5,9,8,11,14,15,17,12,4,2,7,10,13,16,20,18,6,19};
		int[] arr8 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		int[][] testDatas = new int[][] {arr0, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};
		
		for(int[] testArr : testDatas){
			MergeSort.mergeSort(testArr, 0, testArr.length-1);
			System.out.print(Arrays.toString(testArr));
			SortChecker.isSorted(testArr);
		}
		
	}

}

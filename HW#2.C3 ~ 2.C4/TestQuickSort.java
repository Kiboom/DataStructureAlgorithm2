package quick_sort;

import static quick_sort.QuickSort.quickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class TestQuickSort {

	public static void main(String[] args) {
		ArrayList<int[]> testArrays = generateArrays();

		for(int idx=0 ; idx<testArrays.size() ; idx++){
			int[] testArr = testArrays.get(idx);
			printResult(testArr, idx);
		}
	}
	
	private static void printResult(int[] arr, int idx){
		if(idx==0){
			System.out.println("-----------------------[증가 및 감소 배열의 파티션 결과]-----------------------\n");
		}
		if(idx==2){
			System.out.println("\n-----------------------[원소 개수가 1~32인 배열의 파티션 결과]-----------------------\n");
		}
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		System.out.println("sorted : " + isSorted(arr) + "\n");
	}
	
	public static boolean isSorted(int[] arr) {
		if(arr==null){
			System.out.println("No Array Input!");
			return false;
		}
		for(int i=1 ; i<arr.length ; i++){
			if(arr[i-1] > arr[i]){
				return false;
			}
		}
		return true;
	}

	public static ArrayList<int[]> generateArrays(){
		ArrayList<int[]> testArrays = new ArrayList<int[]>();
		
		int[] increasingArr = {1,2,3,4,5,6,7,8,9,10};
		int[] decreasingArr = {10,9,8,7,6,5,4,3,2,1};
		
		testArrays.add(increasingArr);
		testArrays.add(decreasingArr);
		
		for(int i=1 ; i<=32 ; i++){
			int[] testArr = new int[i];
			for(int j=0 ; j<testArr.length ;  j++){
				testArr[j] = (int)(Math.random()*32);
			}
			testArrays.add(testArr);
		}
		
		return testArrays;
	}
}

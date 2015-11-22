package quick_sort;

import java.util.ArrayList;
import java.util.Arrays;
import static quick_sort.QuickSort.*;

public class TestPartition {

	public static void main(String[] args) {
		ArrayList<int[]> testArrays = generateArrays();

		for(int idx=0 ; idx<testArrays.size() ; idx++){
			int[] testArr = testArrays.get(idx);
			printResult(testArr, idx);
		}
	}
	
	public static void printResult(int[] arr, int idx){
		if(idx==0){
			System.out.println("-----------------------[증가 및 감소 배열의 파티션 결과]-----------------------\n");
		}
		if(idx==2){
			System.out.println("\n-----------------------[원소 개수가 1~32인 배열의 파티션 결과]-----------------------\n");
		}
		
		int pivotValue = arr[arr.length-1];
		int pivotedPos = partition(arr, 0, arr.length-1);
		boolean isPartitioned = isPartitioned(arr, pivotedPos);
		
		System.out.println(Arrays.toString(arr));
		System.out.println("pivot value : " + pivotValue +
				", pivoted position : " + pivotedPos + 
				", partitioned : " + isPartitioned + "\n");
	}
	
	public static boolean isPartitioned(int[] arr, int pivotedPos) {
		if(arr==null){
			System.out.println("No Array Inputed!");
			return false;
		}
		for(int i=pivotedPos+1 ; i<arr.length ; i++){
			if(arr[i]<arr[pivotedPos]){
				return false;
			}
		}
		for(int i=pivotedPos-1 ; i>=0 ; i--){
			if(arr[i]>arr[pivotedPos]){
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

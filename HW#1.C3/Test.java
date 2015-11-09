package maximum_subarray;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		MaxSubarrayFinder_n2 finder_n2 = new MaxSubarrayFinder_n2();		 // O(n^2) 방법
		MaxSubarrayFinder_nlogn finder_nlogn = new MaxSubarrayFinder_nlogn();  // O(nlogn) 방법
		
		int[] arr1 = {1};
		int[] arr2 = {1,-1};
		int[] arr3 = {0,0,0,0};
		int[] arr4 = {1,2,-3,4};
		int[] arr5 = {-4, -3, -2, -1};
		int[] arr6 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		int[] arr7 = {};
		
		int[][] testArrays = {arr1, arr2, arr3, arr4, arr5, arr6, arr7};
		
		for(int[] arr : testArrays){
			ResultInfo result_n2 = finder_n2.findMaxSubarray(arr, 0, arr.length-1);
			ResultInfo result_nlogn = finder_nlogn.findMaxSubarray(arr, 0, arr.length-1);
			System.out.println(Arrays.toString(arr));
			System.out.println(result_n2 + " - O(n^2) 방법");
			System.out.println(result_nlogn + " - O(nlogn) 방법");
			System.out.println(isTwoResultsSame(result_n2, result_nlogn) + "\n");
		}
	}

	public static boolean isTwoResultsSame(ResultInfo result_n2, ResultInfo result_nlogn){
		if(result_n2.getMaxSum()==result_nlogn.getMaxSum()){
			System.out.print("두 결과는 같습니다! ");
			return true;
		}
		System.out.print("두 결과는 다릅니다! ");
		return false;
	}
}

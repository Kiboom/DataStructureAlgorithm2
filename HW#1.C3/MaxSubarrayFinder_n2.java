package maximum_subarray;

import java.util.ArrayList;

public class MaxSubarrayFinder_n2 {

	// MaxSubarray : lowIdx, highIdx, maxSum
	public MaxSubarray getMaxSubarray(int[] arr, int lowIdx, int highIdx){
		if(exceptionChecker(arr, lowIdx, highIdx)){
			return null;
		}		
		
		ArrayList<MaxSubarray> pairs = new ArrayList<MaxSubarray>(); 
		
		for(int i=lowIdx ; i<=highIdx ; i++){
			int maxIdx=i;
			int sum=arr[i], maxSum=arr[i];
			for(int j=i+1 ; j<=highIdx ; j++){
				sum += arr[j];
				if(sum > maxSum){
					maxSum = sum;
					maxIdx = j;
				}
			}
			pairs.add(new MaxSubarray(i, maxIdx, maxSum));
		}
		
		MaxSubarray maxPairs = pairs.get(0);
		for(int i=1 ; i<pairs.size() ; i++){
			if(pairs.get(i).getSum() > maxPairs.getSum()){
				maxPairs = pairs.get(i);
			}
		}
		return maxPairs;
	}
	
	public boolean exceptionChecker(int[] arr, int lowIdx, int highIdx){
		if(arr==null || arr.length<=0){
			System.out.println("빈 배열이 들어왔습니다!");
			return true;
		}
		if(lowIdx>highIdx || lowIdx<0 || highIdx<0 || lowIdx>=arr.length || highIdx>=arr.length){
			System.out.println("인덱스 범위 오류!");
			return true;
		}
		return false;
	}
}

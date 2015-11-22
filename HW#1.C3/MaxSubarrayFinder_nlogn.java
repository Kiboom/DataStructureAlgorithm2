package maximum_subarray;

public class MaxSubarrayFinder_nlogn {

	// MaxSubarray : lowIdx, highIdx, maxSum
	public MaxSubarray getMaxSubarray(int[] arr, int lowIdx, int highIdx){
		if(exceptionChecker(arr, lowIdx, highIdx)){
			return null;
		}
		if(lowIdx==highIdx){	
			return new MaxSubarray(lowIdx, highIdx, arr[lowIdx]);
		}
		
		int midIdx = lowIdx + (highIdx-lowIdx)/2;
		
		MaxSubarray leftMaxSubarray = getMaxSubarray(arr, lowIdx, midIdx);
		MaxSubarray rightMaxSubarray = getMaxSubarray(arr, midIdx+1, highIdx);
		MaxSubarray crossingMaxSubarray = findMaxCrossingSubarray(arr, lowIdx, highIdx);
		
		return compareSubarrays(leftMaxSubarray, rightMaxSubarray, crossingMaxSubarray);
	}
	
	
	private MaxSubarray compareSubarrays(MaxSubarray leftMaxSubarray, MaxSubarray rightMaxSubarray, MaxSubarray crossingMaxSubarray) {
		if(leftMaxSubarray.getSum() >= rightMaxSubarray.getSum() 
				&& leftMaxSubarray.getSum() >= crossingMaxSubarray.getSum() ){
			return leftMaxSubarray;
		}
		else if(rightMaxSubarray.getSum() >= leftMaxSubarray.getSum() 
				&& rightMaxSubarray.getSum() >= crossingMaxSubarray.getSum() ){
			return rightMaxSubarray;
		}
		else
			return crossingMaxSubarray;
	}


	MaxSubarray findMaxCrossingSubarray(int[] arr, int lowIdx, int highIdx){
		if(exceptionChecker(arr, lowIdx, highIdx)){
			return null;
		}
		if(lowIdx==highIdx){
			return new MaxSubarray(lowIdx, highIdx, arr[lowIdx]);
		}
		
		int midIdx = lowIdx + (highIdx-lowIdx)/2;
		int maxLeft=midIdx, maxRight=midIdx+1;
		int leftSum=arr[midIdx], leftMaxSum=arr[midIdx];
		int rightSum=arr[midIdx+1], rightMaxSum=arr[midIdx+1];
		
		for(int i=midIdx-1 ; i>=lowIdx ; i--){
			leftSum += arr[i];
			if(leftSum>leftMaxSum){
				leftMaxSum = leftSum;
				maxLeft = i;
			}
		}
		for(int i=midIdx+2 ; i<=highIdx ; i++){
			rightSum += arr[i];
			if(rightSum>rightMaxSum){
				rightMaxSum = rightSum;
				maxRight = i;
			}
		}
		
		return new MaxSubarray(maxLeft, maxRight, leftMaxSum+rightMaxSum); 
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



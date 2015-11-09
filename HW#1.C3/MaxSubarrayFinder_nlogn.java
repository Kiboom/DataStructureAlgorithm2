package maximum_subarray;

public class MaxSubarrayFinder_nlogn {

	// ResultInfo : lowIdx, highIdx, maxSum
	public ResultInfo findMaxSubarray(int[] array, int lowIdx, int highIdx){
		if(array==null || array.length<=0){
			System.out.println("빈 배열이 들어왔습니다!");
			return null;
		}
		if(lowIdx>highIdx || lowIdx<0 || highIdx<0 || lowIdx>=array.length || highIdx>=array.length){
			System.out.println("인덱스 범위 오류!");
			return null;
		}
		if(lowIdx==highIdx){	
			return new ResultInfo(lowIdx, highIdx, array[lowIdx]);
		}
		
		int midIdx = lowIdx + (highIdx-lowIdx)/2;
		
		ResultInfo leftMaxSubarray = findMaxSubarray(array, lowIdx, midIdx);
		ResultInfo rightMaxSubarray = findMaxSubarray(array, midIdx+1, highIdx);
		ResultInfo crossingMaxSubarray = findMaxCrossingSubarray(array, lowIdx, highIdx);
		
		return compareSubarrays(leftMaxSubarray, rightMaxSubarray, crossingMaxSubarray);
	}
	
	
	private ResultInfo compareSubarrays(ResultInfo leftMaxSubarray, ResultInfo rightMaxSubarray, ResultInfo crossingMaxSubarray) {
		if(leftMaxSubarray.getMaxSum() >= rightMaxSubarray.getMaxSum() 
				&& leftMaxSubarray.getMaxSum() >= crossingMaxSubarray.getMaxSum() ){
			return leftMaxSubarray;
		}
		else if(rightMaxSubarray.getMaxSum() >= leftMaxSubarray.getMaxSum() 
				&& rightMaxSubarray.getMaxSum() >= crossingMaxSubarray.getMaxSum() ){
			return rightMaxSubarray;
		}
		else
			return crossingMaxSubarray;
	}


	ResultInfo findMaxCrossingSubarray(int[] array, int lowIdx, int highIdx){
		if(array==null || array.length<=0){
			System.out.println("빈 배열이 들어왔습니다!");
			return null;
		}
		if(lowIdx>highIdx || lowIdx<0 || highIdx<0 || lowIdx>=array.length || highIdx>=array.length){
			System.out.println("인덱스 범위 오류!");
			return null;
		}
		if(lowIdx==highIdx){
			return new ResultInfo(lowIdx, highIdx, array[lowIdx]);
		}
		
		int midIdx = lowIdx + (highIdx-lowIdx)/2;
		int maxLeft=midIdx, maxRight=midIdx+1;
		int leftSum=array[midIdx], leftMaxSum=array[midIdx];
		int rightSum=array[midIdx+1], rightMaxSum=array[midIdx+1];
		
		for(int i=midIdx-1 ; i>=lowIdx ; i--){
			leftSum += array[i];
			if(leftSum>leftMaxSum){
				leftMaxSum = leftSum;
				maxLeft = i;
			}
		}
		for(int i=midIdx+2 ; i<=highIdx ; i++){
			rightSum += array[i];
			if(rightSum>rightMaxSum){
				rightMaxSum = rightSum;
				maxRight = i;
			}
		}
		
		return new ResultInfo(maxLeft, maxRight, leftMaxSum+rightMaxSum); 
	}
	
}



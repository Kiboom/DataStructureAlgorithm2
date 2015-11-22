package maximum_subarray;

public class MaxSubarrayFinder_n {

	// MaxSubarray : lowIdx, highIdx, maxSum
	public MaxSubarray getMaxSubarray(int[] arr, int lowIdx, int highIdx){
		if(exceptionChecker(arr, lowIdx, highIdx)){
			return null;
		}
		
		MaxSubarray[] suffixes = new MaxSubarray[highIdx+1]; 
		suffixes[lowIdx] = new MaxSubarray(lowIdx, lowIdx, arr[lowIdx]);
		
		for(int i=lowIdx+1 ; i<=highIdx ; i++){
			if(suffixes[i-1].getSum() < 0){
				suffixes[i] = new MaxSubarray(i, i, arr[i]);
			}
			else{
				MaxSubarray previous = suffixes[i-1];
				suffixes[i] = new MaxSubarray(previous.getLowIdx(), i, previous.getSum() + arr[i]);
			}
		}
		
		MaxSubarray max = suffixes[lowIdx];
		for(int i=lowIdx+1 ; i<=highIdx ; i++){
			if(max.getSum() < suffixes[i].getSum()){
				max=suffixes[i];
			}
		}
		return max;
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

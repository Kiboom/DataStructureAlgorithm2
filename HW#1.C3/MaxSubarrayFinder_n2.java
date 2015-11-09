package maximum_subarray;

import java.util.ArrayList;

public class MaxSubarrayFinder_n2 {

	ResultInfo findMaxSubarray(int[] array, int lowIdx, int highIdx){
		if(array==null){
			return null;
		}
		if(lowIdx>highIdx || lowIdx<0 || highIdx<0 || lowIdx>=array.length || highIdx>=array.length){
			System.out.println("인덱스 범위 오류!");
			return null;
		}		
		
		ArrayList<ResultInfo> pairs = new ArrayList<ResultInfo>(); 
		
		for(int i=lowIdx ; i<=highIdx ; i++){
			int maxIdx=i;
			int sum=array[i], maxSum=array[i];
			for(int j=i+1 ; j<=highIdx ; j++){
				sum += array[j];
				if(sum > maxSum){
					maxSum = sum;
					maxIdx = j;
				}
			}
			pairs.add(new ResultInfo(i, maxIdx, maxSum));
		}
		
		ResultInfo maxPairs = pairs.get(0);
		for(int i=1 ; i<pairs.size() ; i++){
			if(pairs.get(i).getMaxSum() > maxPairs.getMaxSum()){
				maxPairs = pairs.get(i);
			}
		}
		return maxPairs;
	}
}

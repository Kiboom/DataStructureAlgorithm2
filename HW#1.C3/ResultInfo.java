package maximum_subarray;

public class ResultInfo {
	private int lowIdx; 
	private int highIdx;
	private int maxSum;
	
	public ResultInfo(int lowIdx, int highIdx, int maxSum) {
		this.lowIdx = lowIdx;
		this.highIdx = highIdx;
		this.maxSum = maxSum;
	}
	
	/*Getter and Setter*/
	public int getLowIdx() {
		return lowIdx;
	}
	public int getHighIdx() {
		return highIdx;
	}
	public int getMaxSum() {
		return maxSum;
	}

	@Override
	public String toString() {
		return "Maximum Subarray [index=" + lowIdx + "~" + highIdx + ", sum=" + maxSum + "]";
	}
		
}

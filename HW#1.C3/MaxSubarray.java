package maximum_subarray;

public class MaxSubarray {
	private int lowIdx; 
	private int highIdx;
	private int Sum;
	
	public MaxSubarray(int lowIdx, int highIdx, int Sum) {
		this.lowIdx = lowIdx;
		this.highIdx = highIdx;
		this.Sum = Sum;
	}
	
	/*Getter and Setter*/
	public int getLowIdx() {
		return lowIdx;
	}
	public int getHighIdx() {
		return highIdx;
	}
	public int getSum() {
		return Sum;
	}
	public void setLowIdx(int lowIdx) {
		this.lowIdx = lowIdx;
	}
	public void setHighIdx(int highIdx) {
		this.highIdx = highIdx;
	}
	public void setSum(int Sum) {
		this.Sum = Sum;
	}

	@Override
	public String toString() {
		return "Maximum Subarray [index=" + lowIdx + "~" + highIdx + ", sum=" + Sum + "]";
	}
		
}

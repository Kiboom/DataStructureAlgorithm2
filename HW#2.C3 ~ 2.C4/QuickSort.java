package quick_sort;

public class QuickSort {

	public static void quickSort(int[] arr, int start, int end){
		if(arr==null || start>=end){
			return;
		}
		
		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot+1, end);
	}
	
	public static int partition(int[] arr, int start, int end) {
		if(arr==null || start>end){
			return -1;
		}
		if(start==end){
			return start;
		}
		
		int pivotValue = arr[end];
		int endOfLowBlock = -1;
		
		for(int posToBeChecked = 0 ; posToBeChecked<end ; posToBeChecked++){
			if(arr[posToBeChecked] <= pivotValue){
				endOfLowBlock++;
				swap(arr, posToBeChecked, endOfLowBlock);
			}
		}
		swap(arr, endOfLowBlock+1, end);
		
		return endOfLowBlock+1;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

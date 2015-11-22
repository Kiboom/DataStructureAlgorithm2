package heap_sort;

public class MaxHeapify {

	public static void maxHeapify (HeapTree heap, int pos){
		if(heap==null){
			return;
		}
		
		int leftChildPos = 2*pos;
		int rightChildPos = leftChildPos+1;
		int largestPos = pos;
		
		int heapSize = heap.getSize();
		int[] heapElements = heap.getElements();
		
		if(leftChildPos < heapSize && heapElements[leftChildPos] > heapElements[pos]){
			largestPos = leftChildPos;
		}
		if(rightChildPos < heapSize && heapElements[rightChildPos] > heapElements[largestPos]){
			largestPos = rightChildPos;
		}
		if(largestPos != pos){
			swap(heapElements, pos, largestPos);
			maxHeapify(heap, largestPos);
		}
	}

	public static void swap(int[] heapElements, int a, int b) {
		int temp = heapElements[a];
		heapElements[a] = heapElements[b];
		heapElements[b] = temp;
	}
}

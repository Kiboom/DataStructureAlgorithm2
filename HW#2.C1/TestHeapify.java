package heap_sort;

import static heap_sort.MaxHeapify.maxHeapify;

public class TestHeapify {

	public static void main(String[] args) {
		HeapTree heap = makeSampleHeap(11);
		
		System.out.println(isMaxHeap(heap.getElements()));
		maxHeapify(heap, 1);
		System.out.println("[Heapified Heap]");
		System.out.println(heap);
		System.out.println(isMaxHeap(heap.getElements()));
	}

	public static HeapTree makeSampleHeap(int size) {
		HeapTree sampleHeap = new HeapTree(new int[size]);
		sampleHeap.setElements(0, 0);
		sampleHeap.setElements(1, 1);
		
		for(int i=2 ; i<size ; i++){
			sampleHeap.setElements(size-i+1, i);
		}
		
		System.out.println("[Generated Heap]"); 
		System.out.println(sampleHeap);
		return sampleHeap;
	}

	public static String isMaxHeap(int[] heapElements){
		if(heapElements==null){
			return "		--> This is not Maxheap\n";
		}
		for(int i=2 ; i<heapElements.length ; i++){
			if(heapElements[i/2]<heapElements[i])		// 나와 내 부모를 비교!
				return "		--> This is not Maxheap\n";
		}
		return "		--> This is Maxheap!\n";
	}
}

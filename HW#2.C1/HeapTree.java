package heap_sort;

public class HeapTree {
	private int size;
	private int[] elements;
	
	public HeapTree(int[] heapElements) {
		this.size = heapElements.length;
		this.elements = heapElements;
	}
	
	public int getSize() {
		return size;
	}
	public int[] getElements() {
		return elements;
	}
	public void setElements(int[] elements) {
		this.elements = elements;
	}
	public void setElements(int element, int pos) {
		elements[pos] = element;
	}

	@Override
	public String toString() {
		printHeap();
		return " ";
	}

	public void printHeap(){
		int height = (int)Math.ceil((Math.log10(size)/Math.log10(2)));
		int indent = height;
		
		for(int levelStart=1; levelStart < size ; levelStart*=2, indent--){
			for(int i=0 ; i<=indent ; i++){
				System.out.print("	");
			}
			for(int pos=levelStart ; pos<2*levelStart ; pos++){
				if(pos>=size){
					System.out.println("");
					return;
				}
				if(pos%2==0){
					System.out.print(elements[pos] + "	       ");
				}else{
					System.out.print(elements[pos] + "  ");
				}
			}
			System.out.println("");
		}
	}
}

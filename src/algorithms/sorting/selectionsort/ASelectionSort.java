package sorting.selectionsort;
/*
 * Pick the position of next smallest number && swap with the current one.
 * There is no best case or worst case for this algorithm. its order is always o(n^2)
 */
public class ASelectionSort {
	
	public static void main(String[] args) {
		int[] arr = {1,3,2,6,13,9, 1, 6, 2, 234, 22, 435, 221, 3};
		printArray(arr);
		int len = arr.length;
		for(int i=0; i<len; ++i){
			int nextMinPos = minPos(arr, i, len-1);
			if(nextMinPos!=i){
				swap(arr, i, nextMinPos);
			}
		}
		
	}
	
	private static int minPos(int[] arr, int bottom, int top) {
		int m = arr[bottom];
		int index = bottom;
		for(int i=bottom + 1; i<= top; ++i){
			if(arr[i]<m){
				m=arr[i];
				index=i;
			}
		}
		return index;
	}

	/*
	 * swap i'th and j'th elements of array arr
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		printArray(arr, i, j);
	}

	public static void printArray(int[] set, Integer... indeces) {
		System.out.print("[");
		if (set.length > 0) { System.out.print(set[0]);	}
		for (int i = 1; i < set.length; i++) {
			if(indeces.length > 0 && (indeces[0]==i || indeces[1]==i)){
				System.out.print(", (" + set[i] + ")");
			}else{
				System.out.print(", " + set[i]);
			}
		}
		System.out.println("]");
	}

}

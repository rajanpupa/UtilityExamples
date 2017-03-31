package sorting.insertionsort;

/*
 * Best case o(n), while loop is always false for sorted array
 * Worst case o(n2) , 
 * Inplace
 */
public class AInsertionSort {
	
	public void sort(int[] arr){
		
		int ie, je;
		int k=0;
		for(int i=1; i<arr.length; i++){
			ie = arr[i];
			k = i;
			
			// subarray before ith position is always sorted.
			// so this loop is breaked if not needed
			for(int j=i; j>0 ; j--){
				je = arr[j-1];
				
				if(je > ie){
					// needs swap, so update the index
					k--;
				}else{
					break;
				}
			}
			
			if(k< i){
				// shift the subarray and insert
				System.arraycopy(arr, k, arr, k+1, i-k);
				arr[k] = ie;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,2,6,13,9, 1, 6, 2, 234, 22, 435, 221, 3};
		//sort1(arr);
		
		AInsertionSort i = new AInsertionSort();
		
		i.sort(arr);;
		
		printArray(arr);
		
	}

	private static void sort1(int[] arr) {
		
		printArray(arr);
		
		
		int len = arr.length;
		int temp = 0;
		int j = 0;
		for(int i=1; i<len; ++i){
			temp = arr[i];
			j=i;
			while(j>0 && temp < arr[j-1]){
//				printArray(arr, j, j-1);
				arr[j] = arr[j-1];
				
				j--;
			}
			arr[j]=temp;
			printArray(arr, i, j);
		}
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

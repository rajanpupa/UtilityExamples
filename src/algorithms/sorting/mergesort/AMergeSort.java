package sorting.mergesort;
/*
 * Divide and conquer algorithm
 * 
 * 
 */
public class AMergeSort {

	public static void main(String[] args) {
		int[] arr = {1,3,2,6,13,9, 1, 6, 2, 234, 22, 435, 221, 3};
		printArray(arr);
		
		int n = arr.length;
		int [] tempStorage = new int[n];
		tempStorage = arr;
		
		
	}
	
	public static void mergeSort(int[] arr, int lower, int upper){
		if(lower==upper){
			return;
		}else{
			int mid = (lower+upper)/2;
			mergeSort(arr, lower, mid);
			mergeSort(arr,mid+1,upper);
			merge(arr, lower,mid+1, upper);
		}
	}

	private static void merge(int[] arr, int lowerPointer, int upperPointer, int upperBound) {
		int j=0;
		int lowerBound = lowerPointer;
		int n=upperBound - lowerBound +1;
		
		int mid = upperPointer -1;
		
		while(lowerPointer <= mid && upperPointer <= upperBound){
			if(arr[lowerPointer]< arr[upperPointer]){
				
			}
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

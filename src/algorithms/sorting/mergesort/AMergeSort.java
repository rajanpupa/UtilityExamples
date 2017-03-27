package sorting.mergesort;
/*
 * Divide and conquer algorithm
 * 
 * 
 */
public class AMergeSort {

	public static void main(String[] args) {
		//int[] arr = {1,3,2,6,13,9, 1, 6, 2, 234, 22, 435, 221, 3};
		int[] arr = {6,5,4,3, 2,1};
		printArray(arr);
		
		inPlaceMergeSort(arr, 0, arr.length-1);
		
		printArray(arr);
		
		// ----------------------------------
		
		//mainMergeSortDemo();
	}

	// not inplace, merges two arrays
	private static void mainMergeArrDemo() {
		int[] arr = {1,3,7,9};
		int[] arr2 = {2,4,5,6};
		
		int[] arr3 = mergeSortedArrays(arr, arr2);
		
		printArray(arr3);
	}
	
	
	public static void inPlaceMergeSort(int[] arr, int lower, int upper){
		if(lower>=upper){
			// already sorted or only one element
			return;
		}else{
			int mid = (lower+upper)/2;
			inPlaceMergeSort(arr, lower, mid);
			inPlaceMergeSort(arr,mid+1,upper);
			merge(arr, lower,mid, upper);
		}
	}

	// inplace merge sorted halves of array
	private static void merge(int[] arr, int lower, int mid, int upper) {
		int n=upper - lower +1;
		
		int l = lower, m = mid + 1, u = upper;
		
		int tmp;
		while(l <= mid && m <= upper){
			if(arr[l] <= arr[m]){
				l++;
				printArray(arr, l-1, m);
			}else if(arr[l] > arr[m]){
				tmp = arr[m];
				// shift subarray right
				// System.arraycopy(src, srcPos, dest, destPos, length);
				System.arraycopy(arr, l, arr, l+1, m-l);
				arr[l] = tmp;
				l++;
				m++;
				mid++;
				printArray(arr, l-1, m-1);
			}
		}//while
		
		
	}
	
	/**
	 * takes two sorted arrays and returns a merged sorted array
	 * not inplace
	 */
	private static int [] mergeSortedArrays(int[] arr1, int[] arr2){
		int[] arr3 = new int[arr1.length + arr2.length];
		
		int arr1Ind = 0, arr2Ind = 0, ind=0;
		while(arr1Ind < arr1.length && arr2Ind < arr2.length){
			if(arr1[arr1Ind] < arr2[arr2Ind]){
				arr3[ind] = arr1[arr1Ind++];
			}else {
				arr3[ind] = arr2[arr2Ind++];
			}
			ind++;
		}
		while(arr1Ind < arr1.length){
			arr3[ind++] = arr1[arr1Ind++];
		}
		
		while(arr2Ind < arr2.length){
			arr3[ind++] = arr2[arr2Ind++];
		}
		
		return arr3;
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

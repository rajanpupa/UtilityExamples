package sorting.quicksort;

// Inplace quick sort methods
public class QuickSortExample {
	
	int [] arr ;
	int number;
	
	public QuickSortExample(int[] arr, int num){
		this.arr = arr;
		this.number = num;
	}
	
	private void exchangeNumbers(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	/*
	 * mid middle element as pivot, 
	 * point two fingers i at start, and j and end
	 * slide i fordard until element is less than pivot
	 * slide j backward until its greater than pivot
	 * if i is still before j, exchange the numbers and continue again
	 * if either i or j have not reached the end, quicksort the subarrays on the sideways.
	 */
	public void quickSort(int start, int end){
		
		if(end==start) return;
		
		int i= start, j = end;
		int mid = i + (j-i)/2;
		int pivot = arr[mid];
		
		while(i <= j){
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			if(i<=j){
				exchangeNumbers(i,j);
				j--;
				i++;
			}
		}
		if(start < j){
			quickSort(start, j);
		}
		if(end > i){
			quickSort(i, end);
		}
	}
	
	/**
	 * taking pivot at the end
	 */
	public void quicksort2(int start, int end){
		int 	i = start, 
				j = end ;
		
		int pivot = arr[end];
		
		while(i<=j){
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			
			if(i<=j){
				exchangeNumbers(i, j);
				i++;
				j--;
			}
		}
		if(i<end)
		exchangeNumbers(i, end);
		
		if(start < j){
			quicksort2(start, j);
		}
		if(end > i){
			quicksort2(i, end);
		}
	}

	
	public static void main(String[] args) {
		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		int[] input2 = {1, 3, 9 ,8 ,2 ,7 ,5};
		
		quicksort(input2);
		
		printArr(input2);
	}

	private static void printArr(int[] input) {
		for(int i=0; i<input.length; i++){
			System.out.print(input[i] + " ");
		}
	}
	
	// simple 
	public static void quicksort(int[] arr){
		
		QuickSortExample q = new QuickSortExample(arr, arr.length);
		
		//q.quickSort(0, arr.length-1);
		
		q.quicksort2(0, arr.length-1);
		
		
	}
}

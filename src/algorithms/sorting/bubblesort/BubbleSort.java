package sorting.bubblesort;

public class BubbleSort {
	
	public static void sort(int[] arr){
		printArray(arr);
		int temp=0;
		for(int i=0; i<arr.length-1; i++){
			if(i==5){
				int a=1;
				a = 2;
			}
			
			for(int j=i+1; j<arr.length; j++){
				int ai = arr[i];
				int aj = arr[j];
				if(ai > aj){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					printArray(arr, i, j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,2,6,13,9, 1, 6, 2, 234, 22, 435, 221, 3};
		sort(arr);
		printArray(arr);
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
	
	private static final String CHECK_MARK = "\u2713";
	
	public  void func( Integer... b){
		
	}
}

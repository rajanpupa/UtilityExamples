package sorting.bubblesort;

/*
 * if the array is sorted, the iteration will be O(n), else can be O(n^2)
 */
public class BubbleSort2 {

	public static void sort(int[] arr){
		boolean flag = true;
		int temp;
		while(flag){
			flag=false;
			for(int i=0; i<arr.length-1; i++){
				if(arr[i] > arr[i+1]){
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					flag=true;
					printArray(arr);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {500, 600, 1,3,2,6,13,9, 1, 6, 2, 234, 22, 435, 221, 200};
		sort(arr);
		printArray(arr);
	}
	
	public static void printArray(int[] set) {
		System.out.print("[");
		if (set.length > 0) { System.out.print(set[0]);	}
		for (int i = 1; i < set.length; i++) {
			System.out.print(", " + set[i]);
		}
		System.out.println("]");
	}
}

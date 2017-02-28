package arrayshuffle;

public class ArrayShuffle {

	public static void main(String[] args) {
		int[] solutionArray = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };
		
		shuffle(solutionArray);
		
		for(int i=0; i<solutionArray.length; i++){
			System.out.print(solutionArray[i] + ", ");
		}
		
	}
	
	static void shuffle(int[] arr){
		int random = 0;
		int temp;
		for(int i=0; i<arr.length; i++){
			random = (int)(Math.random() * 100) % arr.length;
			
			temp=arr[i];
			arr[i] = arr[random];
			arr[random] = temp;
		}
	}
}

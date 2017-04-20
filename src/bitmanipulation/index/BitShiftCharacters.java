package index;

public class BitShiftCharacters {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		for(int a : arr){
			System.out.printf("%d * 2 = %d \n", a, multiplyBy2(a));
		}
		
		System.out.printf(" %d th power of 2 is %d \n", 3, nthPowerOfTwo(3));
		
	}
	
	public static int nthPowerOfTwo(int n){
		return 1<<n;
	}
	
	public static int multiplyBy2(int a){
		return a<<1;
	}
}

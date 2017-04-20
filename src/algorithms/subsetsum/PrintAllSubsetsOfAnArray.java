package subsetsum;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * print all subsets of a given array.
 * http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 */
public class PrintAllSubsetsOfAnArray {

	public static void main(String[] args) {
		char[] arr = {'a', 'b', 'c', 'd'};
		// there are 2^n subsets of any array of size n
		
		printAllSubsets(arr);
	}

	/**
	 * prints all the subsets of arr
	 * @param arr
	 */
	private static void printAllSubsets(char[] arr) {
		// int can be used as bit vector for up to 31 bits
		// long can be used upto 63 bits
		int num = (1<<arr.length) -1 ; // 2^n - 1 // used as bitvector
		
		System.out.printf(" %d num = %s\n",num, Integer.toBinaryString(num));
		
		List<Character> chars = new ArrayList<>();
		for(int i=0; i<=num; i++){
			chars = new ArrayList<>();
			
			for(int j=0; j<arr.length; j++){
				if( ((1<<j)&i)  > 0){
					chars.add(arr[j]);
				}
			}
			
			System.out.println(chars);
			
		}
		
	}
}

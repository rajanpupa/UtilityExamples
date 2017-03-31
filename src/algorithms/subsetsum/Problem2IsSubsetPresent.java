package subsetsum;

import java.util.Arrays;

/**
 * Problem 2. Brute Force Solution. Formulate your own procedure for solving the
 * SubsetSum Problem. Think of it as a Java method subsetsum that accepts as
 * input S, k, and outputs a subset T of S with the property that the sum of the
 * si in T is k if such a T exists, or null if no such T can be found. (A
 * non-null return value can be thought of as a return of “true” and a null
 * return value signifies “false.”) Implement your idea in Java code.
 * 
 * @author Rajan Prasad Upadhyay
 *
 */

public class Problem2IsSubsetPresent {

	public static void main(String[] args) {
		Integer[] set = { 1, 2, 3, 4, 5, 9, 20, 41,22,  82 };
//		Arrays.sort(set);
		int sum = 42;
		System.out.println(isSubsetPresent(set, sum));
	}
	
	public static Boolean isSubsetPresent(Integer[] set, Integer sum){
		
		if(set[0] == sum){
			System.out.println(set[0]);
			return true;
		}else if(set.length>1){
			Integer[] newSet = Arrays.copyOfRange(set, 1, set.length );
			
			if( isSubsetPresent(newSet, sum) ){
				return true;
			}
			else if(sum-set[0] > 0 ){
				if( isSubsetPresent( newSet, sum-set[0] ) ){ 
					System.out.println("" + set[0]);
					return true; 
				}
			}else {	return false;	}
		}
		
		return false;
	}
	
	public static void printArray(Integer[] set) {
		System.out.print("[");
		if (set.length > 0) { System.out.print(set[0]);	}
		for (int i = 1; i < set.length; i++) {
			System.out.print(", " + set[i]);
		}
		System.out.print("]");
	}
	public static void printArray(Integer[] set, Integer sum) {
		printArray(set);
		System.out.println( " , sum = " + sum);
	}
	
}
/*
  You are given a solution T to a SubsetSum problem with a S = {s0, s1,...,sn-1}
and k some non-negative integer. (Recall that T is a solution if it is a subset of S the sum of
whose elements is equal to k.) Suppose that sn-1 belongs to T. Is it necessarily true that the set
T -{sn-1} is a solution to the SubsetSum problem with inputs S0
, k0 where S0 = {s0, s1,...,sn-2}
and k0 = k - sn-1? Explain. Hint. The sum of an empty set of integers is (by convention) equal
to 0.
*/

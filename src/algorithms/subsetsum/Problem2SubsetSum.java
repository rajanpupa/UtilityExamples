package subsetsum;

/**
 * Problem 2. Brute Force Solution. Formulate your own procedure for solving the
 * SubsetSum Problem. Think of it as a Java method subsetsum that accepts as
 * input S, k, and outputs a subset T of S with the property that the sum of the
 * si in T is k if such a T exists, or null if no such T can be found. (A
 * non-null return value can be thought of as a return of “true” and a null
 * return value signifies “false.”) Implement your idea in Java code.
 * 
 * @author Rajan Prasad Upadhyay
 */
public class Problem2SubsetSum {

	public static void main(String[] args) {
		Integer[] set = { 1, 2, 3, 4, 5, 9, 20, 35, 41, 16, 82 };
		int sum = 42;
		printSubsetSum(set, sum);
	}
	public static void printSubsetSum(Integer[] set, Integer sum) {
		Integer[] subset;
		for (int i = 0; i < set.length; i++) {
			subset = new Integer[]{set[i]};
			recursiveDepthFirstSearch(set, subset, i, sum);
		}
	}
	public static void recursiveDepthFirstSearch(Integer[] set,
			Integer[] subset, int index, int k) {
		int sum = 0;
		for (int a : subset) {
			sum += a;
		}
		// check if sum of subset is k,
		if (sum == k) {
			printArray(subset);
		}
		
		if(sum >= k){
			//System.out.println("returning");
			return;
		}

		// add element in subset, set[index + i] until index + i < set.length
		for(int i=1; index + i < set.length; i++){
			Integer[] newSubset = new Integer[subset.length + 1];
			System.arraycopy(subset, 0, newSubset, 0, subset.length);
			newSubset[subset.length] = set[index + i];
			recursiveDepthFirstSearch(set, newSubset, index + i, k);
		}
	}

	public static void printArray(Integer[] set) {
		System.out.print("[");

		if (set.length > 0) {
			System.out.print(set[0]);
		}
		for (int i = 1; i < set.length; i++) {
			System.out.print(", " + set[i]);
		}
		System.out.println("]");
	}

}

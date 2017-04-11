package arrayshuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Distribute a list of items into n buckets with almost equal items in each
 */
public class ArrayDistribute {

	public static void main(String[] args) {
		List<Integer> buck = Arrays.asList(1,3,6,9,10) ;
		
		List<List<Integer>> bucks = dsitribute(buck, 3);
		
		for(List<Integer> b: bucks){
			System.out.println(b);
		}
		
	}
	
	public static List<List<Integer>> dsitribute(List<Integer> buck, int k){
		
		int n = buck.size();
		int size = (int)( (n+1) / k);
		
		List<List<Integer>> buckets = new ArrayList<List<Integer>>();
		List<Integer> bucket = new ArrayList<Integer>(size);
		
		int i=0; 
		
		while(i < n){
			bucket.add(buck.get(i));
			
			if(bucket.size()==size){
				 buckets.add(bucket);
				 bucket = new ArrayList<Integer> (size);
			}
			
			i++;
		}
		
		if(!bucket.isEmpty()) buckets.add(bucket);
		
		return buckets;
		
	}
}

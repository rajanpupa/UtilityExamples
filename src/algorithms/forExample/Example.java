package forExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Example {
	
	

	public static void main(String[] args) {
       // priorityQueue();
		
		String s = "abcde";
		String s2 = "fghij";
		
		while(!s2.startsWith(s) && s.length()>0){
			s = s.substring(0, s.length()-1);
			System.out.println(s);
		}
    }

	private static void priorityQueue() {
		int [] arr1 = {2, -8, 3, -2, 4, -10};
        int [] arr2 = {-2, -3, -5, -1, -8, -1};
        
        
        
        //System.out.println(findMaxSubseqSum(arr2));
        
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return o2-o1;
        	}
		});
        q.addAll(Arrays.asList(10, 15, 5,4,2,3));
        
        System.out.println(q.remove());
	}
	
	public static int findMaxSubseqSum(int[] arr){
		if(arr==null || arr.length==0) return Integer.MIN_VALUE;
		
		int sum = arr[0];
		int maxSum = arr[0];
		boolean continuous = true;
		
		int min = arr[0], max=arr[0];
		
		for(int i=1; i<arr.length; i++){
			if(min > arr[i]) min = arr[i];
			if(max<arr[i]) max = arr[i];
			
			if(continuous){
				if(sum + arr[i] > sum || sum+arr[i]>0){
					sum += arr[i];
					continuous = true;
				}else{
					if(arr[i] > sum) sum = arr[i];
					continuous = false;
				}
			}else{
				if(arr[i]>sum){
					sum = arr[i];
					continuous=true;
				}
			}
			
			if(sum > maxSum){
				maxSum = sum;
			}
		}
		
		return maxSum;
	}
}

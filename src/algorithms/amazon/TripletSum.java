package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripletSum {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		int[] nums2 = {0,0,0,0};// should return one list
		int[] nums3 ={3,0,-2,-1,1,2};
		int[] nums4 ={1,2,-2,-1};
		// should 
		
		TripletSum ts = new TripletSum();
		System.out.println(ts.threeSum(nums));
	}

	/*
	 * should return distinct list of numbers that sums up to 0
	 * [-1,0,1,2,-1,-4]=> [[-1,0,1],[-1,2,-1]]
	 */
	public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> lst = new ArrayList<>();
       
       for(int i=0; i<nums.length-1; i++){
    	   List<List<Integer>> indexes= findSumIndeces(nums, 0-nums[i]);
    	   
    	   // add the list which do not contain i
    	   for(List<Integer> l : indexes){
    		   if(!l.contains(i)){
    			   List<Integer> l2 = new ArrayList<Integer>();
    			   l2.add(nums[l.get(0)]);
    			   l2.add(nums[l.get(1)]);
    			   l2.add(nums[i]);
//    			   lst.add(l2);
    			   addIfUnique(lst, l2);
    		   }
    	   }
    	   
       }
       
       
       return lst;
        
    }

	private List<List<Integer>> findSumIndeces(int[] nums, int sum) {
		List<List<Integer>> lst = new ArrayList<>();
		Map<Integer, Integer> m = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			if(m.containsKey(nums[i])){
				List<Integer> l = new ArrayList<>();
				l.add(m.get(nums[i]));
				l.add(i);
				lst.add(l);
			}else{
				m.put(sum-nums[i], i);
			}
		}
		return lst;
	}
	
	private void addIfUnique(List<List<Integer>> a, List<Integer> b){
		//System.out.println("checking : " + b);
		boolean flag = false;
		for(List<Integer> l : a){
			flag=true;
			for(Integer i: l){
				if(!b.contains(i)){
					flag=false;
					break;
				}
			}
			if(flag){
				break;
			}
		}
		if(!flag){
			a.add(b);
		}
	}
	
	
}

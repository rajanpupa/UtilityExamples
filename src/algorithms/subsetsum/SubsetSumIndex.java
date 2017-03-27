package subsetsum;

import java.util.Arrays;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 * 
 * return [0, 0] if there is no sum
 * 
 * NOTE: nums and target could be positive, zero or negative
 */
public class SubsetSumIndex {

	public int[] twoSum(int[] nums, int target) {
        int sumx= target, sumy=0;
        
        int[] ans = new int[]{0,0};
        
        int x = 0, y=0;
        
        for(int i=0; i<nums.length-1; i++){
        	sumx = target;
        	x = i;
        	sumx = target - nums[x];
        	
//        	if(sumx < 0){
//        		continue;
//        	}
        	for(int j=i+1; j<nums.length; j++){
        		y = j;
        		sumy = sumx-nums[y];
        		if(sumy == 0){
        			return new int[] {x, y};
        		}else{
        			continue;
        		}
        	}
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		SubsetSumIndex ssi = new SubsetSumIndex();
		
		int[] nums = new int[]{3,7,11,15,6};
		int target = 9;
		
		int[] ans = ssi.twoSum(nums, target);
		System.out.println(ans[0] + ", " + ans[1]);
	}
}

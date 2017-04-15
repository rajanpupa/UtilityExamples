package amazon;

/**
 * In a sorted array, all the elements have duplicated except one.
 * Find the unique element in O(log n) complexity and O(1) space complexity
 */

public class ArrUniqueNumFinder {
	public int singleNonDuplicate(int[] nums) {
       int ans = -1;
       
       int len = nums.length;
       
       int minInd = 0;
       int maxInd = len-1;
       
       while(minInd <= maxInd){
    	   len = maxInd - minInd + 1;
    	   
    	   if(len == 1){
        	   return nums[maxInd];
           }else if(len == 3){
        	   if(nums[minInd]==nums[minInd + 1]){
        		   return nums[maxInd];
        	   }else{
        		   return nums[minInd];
        	   }
           }else{
        	   int pivot = (len + 1)/2;
               
               if(pivot % 2 == 0){// even
            	   if(nums[minInd + pivot] == nums[minInd + pivot-1]){// match left to take left
            		   // update the minInd and maxInd to take the left
            		   maxInd = minInd + pivot - 2;
            	   }else if(nums[minInd + pivot] == nums[minInd + pivot+1]){
            		// update the minInd and maxInd to take the right subarray
            		   minInd = minInd + pivot  + 2;
            	   }else{
            		   return nums[minInd + pivot];
            	   }
               }else{//odd
            	   if(nums[minInd + pivot] == nums[minInd + pivot-1]){//match left so take right
            		   minInd = minInd + pivot + 1;
            	   }else if(nums[minInd + pivot] == nums[minInd + pivot+1]){
            		   maxInd = minInd + pivot  -1;
            	   }else{
            		   return nums[minInd + pivot];
            	   }
               }
           }
    	   
       }
       return ans;
    }
	
	public int singleNonDuplicate2(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
	
	public static void main(String[] args) {
		ArrUniqueNumFinder a = new ArrUniqueNumFinder();
		//int [] nums = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5};
		//int [] nums = new int[] { 1, 2, 2, 3, 3, 4, 4, 5,5};
		int [] nums = new int[] {1, 3, 3, 4, 4, 5, 5,6,6,7,7};
		
		System.out.println(a.singleNonDuplicate2(nums) + "");
	}
}

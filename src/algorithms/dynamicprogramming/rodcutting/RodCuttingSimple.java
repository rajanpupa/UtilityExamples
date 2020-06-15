package dynamicprogramming.rodcutting;

public class RodCuttingSimple {
	
	public static void main(String[] args) {
		// ith index contains price for length i+1
		int[] prices = {1,5,8,9,10,17,17,20,24,30};
		
		RodCuttingSimple rcs = new RodCuttingSimple();
		
		for(int i = 1; i<30; i++) {
			//System.out.printf("len %s --> max rev = %s \n", i, rcs.getMaxRevenue(prices, i));
			System.out.printf("len %s --> max rev = %s \n", i, rcs.memoizedGetMaxRevenue(prices, i));
		}
		
		int i = 12;
		//System.out.printf("len %s --> max rev = %s \n", i, rcs.memoizedGetMaxRevenue(prices, i));
	}
	
	// recursive solution
	public int memoizedGetMaxRevenue(int[] prices, int rodlen) {
		int rev = 0;
		
		// prices including for 0 len as well
		int[] zprices = new int[prices.length + 1];
		System.arraycopy(prices, 0, zprices, 1, prices.length);
		
		int[] revenue = new int[rodlen + 1];
		for(int i=0; i<revenue.length; i++) revenue[i] = -1;
		
		return dfs(zprices, rodlen, revenue);
		
	}
	
	private int dfs(int[] price, int len, int[] revenue) {
		int max = -1;
		
		if(revenue[len] >= 0) {
			return revenue[len];
		}
		
		if(len == 0) {
			max = 0;
		} else {
			for(int i=1; i<=len && i<price.length; i++) {
				// cut in  i and ( len - i )
				int iRev = price[i];							// first cut	
				int lenMinusIRev = dfs(price, len-i, revenue);	// second cut
				
				max = Math.max(max, iRev + lenMinusIRev); // cur cut is great or previous cuts
			}
		}
		revenue[len] = max;
		
		return max;
	}

	// iterative solution
	// calculates the max revenue for 
	public int getMaxRevenue(int[] prices, int rodlen) {
		int rev = 0;
		
		int[] zprices = new int[rodlen + 1] ; // for 0 len as well
		zprices[0] = 0;
		System.arraycopy(
				prices, // src 
				0, 		// src position
				zprices, // dst
				1, 		 // dst position
				prices.length > rodlen ? rodlen : prices.length // length of copy
		);
		
		// calculate max rev for the prices with given length
		for(int i=1; i<zprices.length; i++) {
			rev = -1;
			// all possible cuts of len i, to maximize the revenue
			for(int j=1; j<=i; j++) {
				rev = Math.max(rev, zprices[j] + zprices[i-j]);
			}
			zprices[i] = rev;
		}

		return zprices[rodlen];
	}

}

package dynamicprogramming.knapsack;

/*
 * Given a knapsack which can hold a max of W weight,
 * and a table of n items with vi value and wi weight each,
 * calculate the maximum value that can be hold in the knapsack
 * 
 * item  (n)  | a | b | c | d | e 
 * -------------------------------
 * value (vi) | 15| 12| 9 | 16| 17
 * -------------------------------
 * weight(wi) | 2 | 5 | 3 | 4 | 6
 * 
 * W = 12
 * 
 */
public class KnapsackExample {

	public static int calculateMaxValue(int W, int[] vi, int[] wi){
		 
		int n = vi.length;
		int [][] k = new int[n + 1][W+1];
		
		for(int i=0; i<= n; i++){
			for(int w=0; w<=W; w++){
				if(i==0 || w==0){
					k[i][w] = 0;
				}else if(wi[i-1] <= w){
					// check if the value is max if we pick current weight or without picking cur weight
					k[i][w] = Math.max(
								vi[i-1] + k[i-1][w-wi[i-1]], // cur value + value of (remaining weight limit if cur weight is picked)
								k[i-1][w] // max value until cur weight was picked
							);
				}else{
					k[i][w] = k[i-1][w]; 
				}
			}
		}
		return k[n][W];
	}
	
	public static void main(String[] args) {
		
		int [] vi = {15, 12, 9, 16, 17};
		int [] wi = {2,  5 , 3,  4,  6};
		int W = 12;
		
		System.out.println("max value = " + calculateMaxValue(W, vi, wi));
	}
}
/*
 * Create a 2d array of n+1, W+1 
 * in the first row (item not exists) or first column(weight not exist)
 * than for ath row, update the max value within wth weight limit in the column
 * in the next 
 */
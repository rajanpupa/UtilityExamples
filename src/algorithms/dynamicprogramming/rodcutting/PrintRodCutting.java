package dynamicprogramming.rodcutting;

/*
 * Given a rod of length n, 
 * a table of prices pi for i=1,2,...n (ie. pi is the price of rod of length i)
 * determine the max revenue rn, obtainable by cutting up the rod and selling the pieces.
 * NOTE: if the price of pn of rod of length n is large enough, an optimal solution may require no cutting at all.
 * 
 * length i | 1  2  3  4  5   6   7   8   9   10
 * ---------|----------------------------------------------------------------------------------
 * price pi | 1  5  8  9  10  17  17  20  24  30
 * 
 */
public class PrintRodCutting {
	
	/*
	 * prints the actual lengths n is divided into
	 */
	public static void main(String[] args) {
		int [] pi = {0,1,5,8,9,10,17,17,20,24,30};// prices
		int n = 14; // length of our rod
		int[] r = new int[n+1];
		
		for(int i=0; i<=n; i++) r[i] = -9999;
		
		//to support n > pi.length
		if( n >= pi.length ){
			int[] pi2 = new int[n+1];
			for(int i=0; i<pi.length; i++) pi2[i] = pi[i];
			for(int i=pi.length; i<n; i++) pi2[i] = pi[pi.length-1];
			pi = pi2;
		}
		
		PrintRodCutting rc = new PrintRodCutting();
		int[] s ;
		//optimumRevenue= rc.memoizedCutRodAux(pi, n, r);
		s = rc.bottomUpRod(pi, n, r);
		
		int value=0;
		
		int n2 = n;
		while( n2 > 0 ){
			System.out.print(s[n2] + ", ");
			value += r[s[n2]];
			n2 -= s[n2];
		}
		
		System.out.println("revenue = " + value);
	}
	
	
	public PrintRodCutting(){}
	
	/*
	 * Top down approach.
	 * while calculating the top optimum cost, all the bottom optimum are calculated and memoized
	 */
	public int memoizedCutRodAux(int[] p, int n, int[] r){
		int q=0;
		
		if(r[n] >= 0)	return r[n];
		
		if(n==0){
			q = 0;
		}else{
			q = -9999;
			for(int i=1; i<=n; i++){
				q = Math.max(q, p[i] + memoizedCutRodAux(p, n-i, r));
			}
		}
		r[n] = q;
		
		System.out.println("returning revenue for n=" + n + " is " + q);
		return q;
	}
	
	/*
	 * Bottom top approach <br/>
	 * Returns all the cuts
	 */
	public int[] bottomUpRod(int[] price, int len, int[] revenue){
		int max;
		int[] splits = new int[ len + 2 ];
		
		// revenue of 0 length is 0
		revenue[0] = 0;
		
		for(int i = 1; i <= len; i++){
			max = -9999;
			
			for ( int j = 1; j <= i; j++ ) {
				if(max < price[j] + revenue[i-j]){
					max =  price[j] + revenue[i-j];
					splits[i] = j;
				}
			}
			revenue[i] = max;
		}
		return splits;
	}
	
	/*
	 * Bottom top approach<br/>
	 * 
	 * Returns only the top revenue
	 */
	public int bottomUpRodInt(int[] p, int n, int[] revenue){
		int max ;
		
		// price of len 0 is 0
		revenue[0] = 0;
		
		for(int i=1; i<=n; i++){
			max = -9999;
			
			for(int j=1; j<=i; j++){
				max = Math.max( max, p[j] + revenue[i-j]);
			}
			revenue[i] = max;
		}
		return revenue[n];
	}
	
	
}

/*
 * top down approach: take a length l, and find an optimal solution for n-l
 * buttom up approach: go building optimal solution from the buttom
 */

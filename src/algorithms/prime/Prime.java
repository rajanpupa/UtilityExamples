package prime;

public class Prime {

	public static void main(String[] args) {
		primeNumBetween(1, 100000);
	}
	
	private static void primeNumBetween(int a, int b) {
		
		long time1 = System.currentTimeMillis();
		
		int count = 0;
		for(int i=a; i<b; i++){
			if(isPrime(i)){
				//System.out.print(i + ", ");
				count ++;
			}
		}
		long time2 = System.currentTimeMillis();
		
		System.out.println("\npassed ms time1 = " + (time2-time1) + " count = " + count);
	}
	
	/**
	 * returns true is {num} is prime
	 * @param num
	 * @return
	 */
	private static boolean isPrime(int num) {
		if(num < 2){
			return false;
		}else if(num == 2){
			return true;
		}
		for(int i=2; i<= (int)(num/2); i++){
			if(num%i == 0){
				// not prime
				return false;
			}
		}
		return true;
	}
	
	/*
	 * calculating between 1...10000, this algorithm is 8 times faster
	 */
	private static boolean isPrime2(int num){
		if(num < 2) return false;
		else if(num==2) return true;
		else if(num%2==0)return false;
		
		double sqrt = Math.sqrt(num);
		
		for(int i=3; i<=sqrt; i+=2){
			if(num%i==0) return false;
		}
		
		return true;
		
	}
}

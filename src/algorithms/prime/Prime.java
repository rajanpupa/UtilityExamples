package prime;

public class Prime {

	public static void main(String[] args) {
		primeNumBetween(2, 100);
	}
	
	private static void primeNumBetween(int a, int b) {
		for(int i=a; i<b; i++){
			if(isPrime(i)){
				System.out.print(i + ", ");
			}
		}
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
}

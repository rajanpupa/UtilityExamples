package square;

public class Square {

	public static void main(String[] args) {
		squareNumBetween(1, 1000);
	}
	
	private static void squareNumBetween(int a, int b) {
		// TODO Auto-generated method stub
		for(int i = a; i<=b; i++){
			if(isPerfectSquare(i)){
				System.out.print(i + ", ");
			}
		}
	}
	
	private static boolean isPerfectSquare(int num) {
		if(num < 0){
			return false;
		}else if(num ==0 || num == 1){
			return true;
		}
		int sum = 1;
		for(int i=3; i< num; i+=2){
			sum += i;
			if(sum == num){
				return true;
			}
		}
		return false;
	}
}

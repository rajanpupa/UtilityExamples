package test.finallytest;

public class FinallyTest {
	public static void main(String[] args) {
		System.out.println(testMethod());
	}
	
	public static int testMethod(){
		int [] a = {2, 4, 5, 6};
		int ans = 5;
		try{
			ans = 6;
			//ans = a[5];
			return ans;
		}catch(Exception e){
			ans = 100;
			System.out.println("catch block before returning");
			return ans;
			//System.out.println("catch block after returning");
		}finally{
			System.out.println("finally block executing.");
			ans = 500;
			//return ans;
		}
		//return ans;
	}
}

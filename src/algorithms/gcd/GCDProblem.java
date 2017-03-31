package gcd;

public class GCDProblem {

	static int gcd(int m, int n) {

		int small = (m < n ? m : n);
		int large = (m < n ? n : m);

		System.out.println("large = " + large + ", small = "+ small);
		// equaledian theorem
		// gcd of a,b (where b<a) is same as a , a-b

		if (large - small < small) {
			small = large - small;
			System.out.println("small if = " + small);
		}

		for (int i = 1; i >= 1; i++) {
			if (small % i == 0) {
				int a = (small / i); // ==0;
				int b = (large % a); 
				
				System.out.println( "a=" + a + "  b=" + b  );
				
				if (b == 0) {
					return a;
				}
			}
		}

		return 1;

	}

	public static void main(String[] args) {
		//System.out.println(gcd(51, 678));
		System.out.println(gcd(10, 30));
	}
}

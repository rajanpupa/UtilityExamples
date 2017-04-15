package amazon;

public class IsCycle {
	public boolean isSelfCrossing(int[] x) {

		if (x.length >= 4) {
			if (x[2] <= x[0] && x[3] >= x[1]) {
				return true;
			}
		} 
		if (x.length >= 5) {
			if (x[4] >= x[2] && x[3] < x[1]) {
				return true;
			} else if (x[3] == x[1] && x[4] >= x[2] - x[0]) {
				return true;
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		IsCycle c = new IsCycle();
		
		int[] ar = new int[]{2,1,3,1,1};
		
		System.out.println(c.isSelfCrossing(ar));
	}
}

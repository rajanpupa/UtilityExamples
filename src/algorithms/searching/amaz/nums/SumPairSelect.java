package searching.amaz.nums;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 */
public class SumPairSelect {

	public static void main(String[] args) {
		int[] a = {1,5,2,4,3,7};
		int sum = 7;
		
		Set<Integer> s = new HashSet();
		
		for(int i=0; i<a.length; i++){
			if(s.contains(sum-a[i])){
				System.out.printf("%d + %d = %d\n", a[i], sum-a[i], sum);
				//break;
			}else{
				s.add(a[i]);
			}
		}
	}
}

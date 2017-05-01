package lambdaexamples;

import java.util.Arrays;
import java.util.List;

public class LambdaFunctions {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1,2,3);
		
		int sum = l.stream().reduce(0, (a,b)->a+b);
		
		System.out.println("sum is " + sum);
	}
	
}

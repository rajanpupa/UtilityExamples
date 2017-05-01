package index;

import java.math.BigInteger;

public class BigIntegerEx {

	public static void main(String[] args) {
		bigIntegerBitExample();
	}

	private static void bigIntegerBitExample() {
		String s = "100000000";
		BigInteger b = new BigInteger(s,2);
		b=b.subtract(BigInteger.ONE);
		System.out.println(b.toString(2));
		//return;
		for(;b.compareTo(new BigInteger("110000000",2) )<0; b=b.add(BigInteger.ONE) ){
			System.out.println(b.toString(2));
		}
	}
}

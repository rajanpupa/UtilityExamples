package index;

public class DefaultExample {

	public static void main(String[] args) {
		int a = 1; //  0000001
		int b = 3; // 0000010
		int c = -35;
		int d = 1;
		
		
		System.out.printf(" 1 = %s, -1=%s\n", to32BitBinary(1), to32BitBinary(-1));
		
		System.out.printf(" %s & %s = %s\n", to32BitBinary(a),to32BitBinary( b), to32BitBinary(a&b));
		System.out.printf(" %s | %s = %s\n",to32BitBinary(a),to32BitBinary( b), to32BitBinary(a|b));
		System.out.printf(" %s ^ %s = %s\n",to32BitBinary(a),to32BitBinary( b), to32BitBinary(a^b));
		System.out.printf("~%s = %s\n",to32BitBinary(d), to32BitBinary(~d));
		System.out.printf(" %s << 3 = %s\n",to32BitBinary(a), to32BitBinary(a<<3));
		System.out.printf(" %s >> 3 = %s\n",to32BitBinary(c), to32BitBinary(c>>3));
		System.out.printf(" %s >>> 3 = %s\n",to32BitBinary(c), to32BitBinary(c>>>3));
	}
	
	static String to16BitBinary(int a){
		String str = Integer.toBinaryString(0x10000 | a);
		int len = str.length();
		//System.out.println("len = " + len);
		return str.substring(len>17?16:1);
		
	}
	
	static String to32BitBinary(int a){
		String s= ""; 
		int shift = 31;
		
		if( (a & (1<<shift)) > 0 ){
			s = "" + Integer.toBinaryString(a);;
		}else{
			s = "0"+Integer.toBinaryString(1<<shift | a).substring(1);
		}
		return s;
	}
}

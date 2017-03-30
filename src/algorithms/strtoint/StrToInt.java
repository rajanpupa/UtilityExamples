package strtoint;

public class StrToInt {

	public static void main(String[] args) {
		String str = "1456010299";
		
		int num = 0;
		char c;
		for (int i=0; i<str.length(); i++){
			c = str.charAt(i);
			num = num * 10;
			num = num + (c - '0');
		}
		
		System.out.println("final number plus one = " + (num +1));
	}
}

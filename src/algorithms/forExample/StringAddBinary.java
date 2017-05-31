package forExample;

public class StringAddBinary {
	public static void main(String[] args) {
		StringAddBinary ab = new StringAddBinary();
		
		System.out.println(ab.addBinary("1010", "1011"));
		
	}
	public String addBinary(String a, String b) {

		String x = a.length() > b.length() ? a : b; // longer
		String y = a.length() > b.length() ? b : a; // smaller

		int i = x.length() - 1, j = y.length() - 1;

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (j >= 0) {
			int xc = x.charAt(i) - '0';
			int yc = y.charAt(j) - '0';

			sb.append("" + ((xc + yc + carry) % 2));
			carry = (xc + yc + carry) / 2;
			i--;
			j--;
		}

		while (i >= 0) {
			int xc = x.charAt(i) - '0';
			sb.append("" + ((xc + carry) % 2));
			carry = (xc + carry) / 2;
			i--;
		}

		if (carry > 0)
			sb.append("" + carry);

		return sb.reverse().toString();

	}
}

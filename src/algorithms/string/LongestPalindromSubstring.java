package string;

public class LongestPalindromSubstring {

	public static void main(String[] args) {
		String str1 = "abcdedcabdbdbd";
		String str2 = "asddsa";
		String str3 = "baaaaaac";
		
		String longestPalindrom = findLongestPalnidrom(str3);
		
		System.out.println(longestPalindrom);
	}

	private static String findLongestPalnidrom(String str) {
		if(str==null)return null;
		if(str.length()<=2)return str;
		
		String lp = str.charAt(0)+"";
		
		for(int i=1; i<str.length(); i++){
			String temp1 = lgpOdd(str, i);
			String temp2 = lgpEven(str, i);
			
			if(temp1.length()>lp.length()){
				System.out.println("i=" + i +" temp1=" + temp1 + " lp=" + lp);
				lp = temp1;
			}
			if(temp2.length()>lp.length()){
				System.out.println("i=" + i +" temp2=" + temp2 + " lp=" + lp);
				lp=temp2;
			}
		}
		
		return lp;
	}
	
	private static String lgpEven(String str, int i) {
		//abcdedcabdbdbd
		int j=1;
		for(j=1; i+j-1<str.length() && i-j>=0; j++){
			if(str.charAt(i-j)!=str.charAt(i+j-1)){
				break;
			}
		}
		
		return str.substring(i-j+1, i+j-1);
	}

	private static String lgpOdd(String str, int i){
		// abcdedcabdbdbd
		int j=1;
		for(j=1; i-j>=0 && i+j<str.length() ; j++){
			if(str.charAt(i+j)!=str.charAt(i-j)){
				break;
			}
		}
		
		return str.substring(i-j+1, i+j);
	}
}

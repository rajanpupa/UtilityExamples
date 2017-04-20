package index;

public class DuplicateCharacters {

	/*
	 * String has ascii characters [a-z]
	 * find if the string has duplicate characters or not
	 */
	public static void main(String[] args) {
		String str = "helowrld";
		
		boolean isDuplicate = hasDuplicate(str);
		
		System.out.println(isDuplicate + " ");
	}
	
	private static boolean hasDuplicate(String str){
		// can handle 63 unique bits
		long bigVector = 0;
		
		//System.out.println(Long.toBinaryString(~0));
		
		for(int i=0; i<str.length(); i++){
			
			int c = str.charAt(i)-'a';
			
			System.out.println(Long.toBinaryString(bigVector) + " , and c =" + c);
			
			if((bigVector & (1L<<c)) >0){
				return true;
			}
			bigVector |= 1L<<c;
		}
		
		return false;
	}
}

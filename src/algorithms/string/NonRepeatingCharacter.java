package string;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {

	/**
	 * Find the first non repeated character in the string
	 */
	public static void main(String[] args) {
		String str = "HelloWorlHeWrd";
		Character ans = null;
		
		Map<Character, Integer> countMap = new HashMap();
		
		Character c;
		for(int i=0; i<str.length(); i++){
			c = str.charAt(i);
			
			if(countMap.get(c) != null){
				countMap.put(c, countMap.get(c)+1);
			}else{
				countMap.put(c, 1);
			}
		}
		
		for(int i=0; i<str.length(); i++){
			c = str.charAt(i);
			if(countMap.get(c) == 1){
				ans = c;
				break;
			}
		}
		
		System.out.println("final Answer: " + ans + "");
	}
}
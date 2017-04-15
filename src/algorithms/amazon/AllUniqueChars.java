package amazon;

import java.util.HashSet;
import java.util.Set;

public class AllUniqueChars {
	
	/* By using set */
	public boolean areCharsUnique(String s){
		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<s.length(); i++){
			// set.contains(s.charAt(i));
			if(!set.add(s.charAt(i))) {
				System.out.println(set);
				return false;
			}
		}
		return true;
	}
	
	/* By not using anny data structure */
	public boolean areCU(String s){
		
		char ci;
		char cj;
		for(int i=0; i<s.length(); i++){
			ci = s.charAt(i);
			
			for(int j=i+1; j<s.length(); j++){
				cj = s.charAt(j);
				if(ci==cj)return false;
			}
			
			
		}
		
		return true;
	}

	public static void main(String[] args) {
		String s = "abcdefzcxv";
		
		AllUniqueChars auc = new AllUniqueChars();
		
		System.out.println(auc.areCharsUnique(s));
	}
}

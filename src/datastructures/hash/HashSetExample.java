package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		List<String> fruits = Arrays.asList("apple","orange","banana","apple", "strawberry");

		for(String fruit: fruits){
			if(s.contains(fruit)){
				System.out.printf("%s already exists.\n", fruit);
			}else{
				s.add(fruit);
				System.out.printf("%s added to fruits set\n", fruit);
			}
		}
		
	}
}

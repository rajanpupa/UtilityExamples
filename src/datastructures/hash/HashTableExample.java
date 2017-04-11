package hash;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class HashTableExample {

	public static void main(String[] args) {
		Hashtable<String, Boolean> t = new Hashtable<>();
		
		List<String> fruits = Arrays.asList("apple","orange","banana","apple", "strawberry");
		
		for(String fruit: fruits){
			if(t.containsKey(fruit)){
				System.out.printf("%s already exists.\n", fruit);
			}else{
				t.put(fruit, true);
				System.out.printf("%s added to fruits set\n", fruit);
			}
		}
	}
}

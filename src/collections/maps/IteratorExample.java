package maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorExample {
	
	public static void main(String[] args) {
		//java7example();
		java8example();
	}
	
	public static void java7example(){
		Map<String, String> map = new HashMap<String, String>() {
		      {
		        put("test", "test123");
		        put("test2", "test456");
		      }
		    };

		    for(Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
		      Map.Entry<String, String> entry = it.next();
		      if(entry.getKey().equals("test")) {
		        it.remove();
		      }
		    }
		    
		    map.forEach((a,b)->System.out.println(a + "->" + b));
	}
	
	public static void java8example() {
		Map<String, String> map = new HashMap<String, String>() {
		      {
		        put("test", "test123");
		        put("test2", "test456");
		      }
		};
		
		map.forEach((a,b)->System.out.println(a + "->" + b));
		
		System.out.println("after deletion");
		
		//map.entrySet().removeIf(entry -> entry.getKey().equals("test"));
		//even better
		map.values().removeAll(Collections.singleton("test456"));
		
		map.forEach((a,b)->System.out.println(a + "->" + b));
	}
}

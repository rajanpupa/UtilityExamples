package atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Combination{
    List<List<String>> lst = new ArrayList<>();
    public Combination(){}
    
    public void addList(List<String> l){
        lst.add(l);
    }
    
    public void printCombinations(){
    	Map<List<String>, Integer> gm = new HashMap<>();

    	for(List<String> l : lst){
    		Map<List<String>, Integer> oneTransCombFrequency = oneTransactionCombination(l);
    		
    		for( List key : oneTransCombFrequency.keySet() ){
    			Integer count = gm.get(key);
    			Integer oneTcount = oneTransCombFrequency.get(key);
    			gm.put(key, count==null ? oneTcount : count + oneTcount);
    		}
    	}
	    gm.remove(new ArrayList<>());
	    for(List key : gm.keySet() ){
	        System.out.println(key +"  " + gm.get(key) );
	    }
    }

	private Map<List<String>, Integer> oneTransactionCombination(List<String> l) {
		Map<List<String>, Integer> m = new HashMap<>();
		m.put(new ArrayList(), 1);
		
		List<List<String>> llist = new ArrayList<>();
		
		for(String str : l){
			for(List<String> keylst: m.keySet() ){
				List<String> newKey = new ArrayList<>();
				newKey.addAll(keylst);
				sortedAddList(newKey, str);
				llist.add(newKey);
			}
			
			for(List newList : llist){
				Integer cnt = m.get(newList);
				m.put(newList, cnt==null?1:cnt);
			}
		}
		
		return m;
	}
    
    public void sortedAddList(List<String> lst, String str){
    	if(lst.size() == 0) {
    		lst.add(str);
    		return;
    	}
    	
    	int i=0; 
    	for(; i<lst.size(); i++){
    		if( lst.get(i).compareTo(str) > 0  ){
    			break;
    		}
    	}
    	lst.add(i, str);
    }
    
    public static void main(String[] args){
//        Combination c = new Combination();
//        
//        c.addList(Arrays.asList( "apple", "banana", "lemon"  ));
//        c.addList(Arrays.asList("banana", "berry", "lemon", "orange"));
//        c.addList(Arrays.asList("banana", "berry", "lemon" ));
//        
//        c.printCombinations();
    	
    	System.out.print( combFrequency(Arrays.asList( "apple", "banana", "lemon"  )) );
    }
    
    public static Map<List<String>, Integer> combFrequency(List<String> lst){
    	Map<List<String>, Integer> m = new HashMap<>();
    	
    	long size = 1L << lst.size();
    	for(long i=0; i< size; i++){ // set different bit vector
    		List<String> list = new ArrayList<>();
    		
    		// select terms that are set in the bit vector
    		for(int j=0; j<lst.size() && j<=i; j++ ){
    			if( (i & ( 1L<<j ) )   > 0 ){
    				list.add( lst.get(j) );
    			}
    		}
    		
    		// add the unique combination to the map
    		m.put(list, 1);
    	}
    	
    	return m;
    }
}
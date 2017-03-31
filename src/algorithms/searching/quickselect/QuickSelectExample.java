package searching.quickselect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Selet 4th smallest element from the array
 *
 */
public class QuickSelectExample {

	public static void main(String[] args) {
		int[] arr = {1,1,1};
		
		QuickSelectExample q = new QuickSelectExample();
		
		System.out.println(" 4th smallest element = " + q.quickSelect(arr, 4));
		
	}
	
	// return k'th smallest element from the array
	public int quickSelect(int[] arr, int rank){
		int lrank = rank;
		List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		List<Integer> lelist = new ArrayList<>();
		List<Integer> glist = new ArrayList<>();
		
		int k = lst.get(lst.size()-1);// select last element as pivot
		while(lrank > 0){
			k = lst.get(lst.size()-1);
			
			for(int i=0; i<lst.size()-1; i++){
				if(lst.get(i)<= k ){
					lelist.add(lst.get(i));
				}else{
					glist.add(lst.get(i));
				}
			}
			
			if(lelist.size() == lrank -1){
				return k;
			}else if(lrank <= lelist.size()  ){
				lst = lelist;
				lelist = new ArrayList<Integer>();
				glist = new ArrayList<Integer>();
			}else{
				lrank = lrank - lelist.size()-1;
				lst = glist;
				lelist = new ArrayList<Integer>();
				glist = new ArrayList<Integer>();
			}
		}
		
		return k;
	}
}

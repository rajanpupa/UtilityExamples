package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Theres also comparator interface which could be used for sorting 
 * @author Admin
 *
 */
public class CustomSortingTest implements Comparable<CustomSortingTest> {
	
	int value=0;

    public CustomSortingTest() {
    }
    public CustomSortingTest(int a){
        value=a;
    }
    public static void main(String[] args) {
        List <CustomSortingTest> a=new ArrayList();
        int[] b={1,5,3,7,3,9,100,50,40,30,20,10,11,9,12};
        for(int i=0;i<b.length;i++){
            a.add(new CustomSortingTest(b[i]));
        }
        Collections.sort(a);
        for(int i=0;i<a.size();i++){
            System.out.print(" "+a.get(i).value);
        }
    }

    @Override
    public int compareTo(CustomSortingTest o) {
        if(value<o.value){
            return -1;
        }else if(value==o.value){
            return 0;
        }else{
            return 1;
        }
    }
}

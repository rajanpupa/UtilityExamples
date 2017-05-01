package com.ktm.examples;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Scanner s = new Scanner(System.in);
        
        int samples = 1;
        
        
        
        for(int i=0; i<samples; i++){
            int n = 5;
            int a = 6;
            
            List<List<Integer>> subsets = new ArrayList<>();
            List<Integer> l1 = new ArrayList<>();
            subsets.add(l1);
            
            int[] arr = {3,2,9,9,7};
            int max = -9999;
            
            for(int j=0; j<n; j++){
                //arr[j] = s.nextInt();
                
            	if(max==a-1)break;
                // create all possible subarrays and add to subsets
                List<Integer> l2=null;
               // List<List<Integer>> ss = new ArrayList<>();
                for(List<Integer> l3: subsets){
                    l2 = new ArrayList<Integer>();
                    l2.addAll(l3);
                    l2.add(arr[j]);
                    
                    int s1 = l2.stream().reduce(0, (x,y) -> x+y);
                    if(s1%a > max) max = s1%a;
                    //ss.add(l2);
                }
                if(null!=l2) subsets.add(l2);
            }
            
            System.out.println(max);
        }
    }
    
}

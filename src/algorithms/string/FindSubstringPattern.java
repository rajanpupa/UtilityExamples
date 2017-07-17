package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a text and a pattern, 
 * print all the index where the pattern is found in the text
 * 
 * @author Rajan
 *
 */
public class FindSubstringPattern {
	
	public static void main(String[] args) {
		String txt = "abcdeabcdeabcdabcdeabcdeabcdabcdeabcdeabcdabcdeabcdeabcde";
		for(int i=0; i<1000; i++){
			txt += "abcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcfabcdeabcf";
		}
		String pat = "abcabcdabcd";
		
		for(int i=0; i<100; i++){
			pat += "abcabcdabcdabcabcdabcdabcabcdabcdabcabcdabcdabcabcdabcdabcabcdabcd";
		}
		
		FindSubstringPattern fsp = new FindSubstringPattern(txt, pat);
		List l;
		long t = System.currentTimeMillis();
		// less efficient method
		l = fsp.findPattern1();
		
		System.out.println(" Time = " + (System.currentTimeMillis() -t));
		System.out.println(l);
		
		t = System.currentTimeMillis();
		
		// KMP algorithm, efficient
		 l = fsp.findPattern2();
		System.out.println(" Time = " + (System.currentTimeMillis() -t));
		
		System.out.println(l);
	}

	String text;
	String pat;
	
	public FindSubstringPattern(String text, String pattern){
		this.text = text;
		this.pat = pattern;
	}
	
	public List<Integer> findPattern1(){
		List<Integer> in = new ArrayList<>();
		int n = text.length();
		int m = pat.length();
		
		for(int i=0; i<n-m; i++){
			
			int j=0;
			for(; j<m; j++){
				if(text.charAt(i + j) != pat.charAt(j)){
					break;
				}
			}
			if(j==m) in.add(i);
		}
		
		return in;
		
	}
	
	// KMP Algorithm
	// skip the repeating pattern matching again
	public List<Integer> findPattern2(){
		List<Integer> l = new ArrayList<>();
		int n = text.length();
		int m = pat.length();
		
		int[] lms = lms(pat);
		
		System.out.println(" lms = " + Arrays.toString(lms));
		
		int i=0; // txt index
		int j = 0;// pat index
		char ti, pj;
		while(i<n-m){
			ti = text.charAt(i);
			pj = pat.charAt(j);
			if(ti==pj ){
				i++; j++;
			}
			if(j==m){
				//System.out.println(i-j);
				l.add(i-j);
				j = lms[j-1];
			}else if( ti != pj ){
				if(j != 0 ){
					j = lms[j-1];
				}else{
					i++;
				}
			}
		}
		
		return l;
	}
	
	/*
	 * returns a longest matching suffix array of the pattern input
	 */
	private int[] lms(String p) {
		int [] l = new int[p.length()];
		int i =1; 
		int len  = 0;//len of longest prefix
		int n = p.length();
		l[0] = 0;
		
		long t = System.currentTimeMillis();
		while(i<n){
			if(p.charAt(i) == p.charAt(len)){
				len ++;
				l[i] = len;
				i++;
			}else{
				if(len != 0){
					len = l[len-1];
				}else{
					l[i] = len;// ie 0
					i++;
				}
			}
		}
		
		System.out.println("lms time = " + (System.currentTimeMillis() - t));
		
		return l;
	}
}

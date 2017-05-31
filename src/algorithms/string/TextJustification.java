package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static void main(String[] args) {
		String [] arr = {"This","is","an","example","of","test","justification."};
		String [] arr2 = {"a"};
		String[] arr3 ={"a","b","c","d","e"};//1
		String[] arr4 ={"a","b","c","d","e"};//3
		String[] arr5 ={"What","must","be","shall","be."};//12
		String[] arr6 ={"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was"};//30
		
		TextJustification tj = new TextJustification();
		
		for(String line: tj.fullJustify(arr6, 30)){
			System.out.println("/" + line + "/");
		}
		
	}

	public List<String> fullJustify(String[] words, int maxWidth){
		List<String> lst = new ArrayList<>();
		
		int numWords = words.length;
		
		List<Integer> numLineWords = findNumWords(words, maxWidth);
		
		List<Integer> numSpaces = findSpaces(words, maxWidth, numLineWords);
		
		System.out.println(numLineWords);
		System.out.println(numSpaces);
		
		int i = 0;
		
		
		
		for(int j=0; j<numLineWords.size()-1; j++){
			String mwWord = getWord(words, i, numLineWords.get(j), numSpaces.get(j));
			lst.add(mwWord);
			i+= numLineWords.get(j);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int j=i; j < words.length; j++){
			sb.append(words[j]);
			if(j < words.length-1 ){
				sb.append(" ");
			}
		}
		
		while(sb.length() < maxWidth){
			sb.append(" ");
		}
		
		lst.add(sb.toString());
		
		
		return lst;
	}

	private String getWord(String[] words, int start, int count,int totalSpaces) {
		StringBuilder sb = new StringBuilder();

		sb.append(words[start]);
		
		int spacecnt = 0;
		
		if(count>1){
			int avgSpace = totalSpaces / (count-1);
			if(avgSpace*(count-1) < totalSpaces && spacecnt < totalSpaces){
				sb.append(" ");
				spacecnt++;
			}
			
			for(int i=0; i<avgSpace && spacecnt < totalSpaces; i++){
				sb.append(" ");
				spacecnt++;
			}
		}else{
			for(int i=0; i<totalSpaces && spacecnt<totalSpaces; i++){
				sb.append(" ");
				spacecnt++;
			}
		}
		
		
		for(int i=start+1; i<start + count ; i++){
			sb.append(words[i]);
			if(  ( (totalSpaces-spacecnt)/(count-1) ) * (count-1) < (totalSpaces-spacecnt) ){
				sb.append(" ");
				spacecnt++;
			}
			for(int j=0; j<(totalSpaces)/(count-1) && spacecnt< totalSpaces; j++){
				sb.append(" ");
				spacecnt ++;
			}
		}
		

		return sb.toString();
	}

	private List<Integer> findSpaces(String[] words, int maxWidth,
			List<Integer> numLineWords) {
		
		List<Integer> lst = new ArrayList<>();
		
		int len = 0;
		int i = 0;
		for(int count : numLineWords){
			
			for(int j=count; j>0; j--){
				len += words[i++].length();
			}
			
			lst.add(maxWidth - len);
			len = 0;
		}
		
		
		
		return lst;
	}

	private List<Integer> findNumWords(String[] words, int maxWidth) {
		List<Integer> lst = new ArrayList<Integer>();
		
		int cursum = 0, prevSum=0;
		int i=0;
		
		for(String w: words){
			if(w.length()>0 && i<words.length-1 && i>0){
				cursum += w.length() + 1;
			}else{
				cursum += w.length();
			}
			
			if(cursum > maxWidth){
				lst.add(i);
				i=1;
				cursum = w.length();
				prevSum = cursum;
			}else{
				prevSum = cursum;
				i++;
			}
		}
		
		if(i>0) lst.add(i);
		
		return lst;
	}
}

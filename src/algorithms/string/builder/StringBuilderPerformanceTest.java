package string.builder;

/*
 * To test if append has the same effect as insert(i, char).
 * 
 * Does StringBuilder internally uses linked list or array to store characters.
 * If linked list, no problem, if array, it has to shift the chars every time capacity is exceeded;
 * 
 */
public class StringBuilderPerformanceTest {
	
	public static void main(String[] args) {
		
		String str1 = "Hello World";
		int count = 100000;
		char c = 'o';
		
		long appendTime1 = calcAppendTime(str1, c, count);
		long insertTime2 = calcInsertTime(str1, c, count);
		long strConcTime3 = calcStringAddTime(str1, c, count);
		
		System.out.printf("appendTime = %d, insertTime = %d, strConcatTime=%d", appendTime1, insertTime2, strConcTime3);
	}

	private static long calcStringAddTime(String str1, char c, int count) {
		long time1 = System.currentTimeMillis();
		for(int i=0; i<count; i++){
			str1 += c;
		}
		long time2 = System.currentTimeMillis();
		return time2-time1;
	}

	private static long calcInsertTime(String str1, char c, int count) {
		// TODO Auto-generated method stub
		long time1 = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder("Inserted : ");
		sb.append(str1);
		
		for(int i=0; i<count; i++){
			sb.insert(0, c);
		}
		
		//System.out.println(sb.toString());
		
		long time2 = System.currentTimeMillis();
		
		return time2-time1;
	}

	/*
	 * appends c to str1 , count number of times
	 */
	private static long calcAppendTime(String str1, char c, int count) {
		
		long time1 = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder("Appended: ");
		sb.append(str1);
		
		for(int i=0; i<count; i++){
			sb.append(c);
		}
		
		//System.out.println(sb.toString());
		
		long time2 = System.currentTimeMillis();
		
		return time2-time1;
	}

}

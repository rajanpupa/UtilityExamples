package atlassian;

public class LookAndSays {

	public static void main(String[] args) {
		System.out.println(LookAndSay("  ", 1));
		//System.out.println(convert(7));
	}
	
	// find the index of the sublist in the list
	static int find(int[] list, int[] sublist){
		
		return -1;
	}
	
	static char[] mp = {'0' , 'a','t','l','s','i','n'};
	// convert a integer to base 7 ( 7 --> a0 )
	static String convert(long input) {
		final int BASE =7;
		
		StringBuilder sb = new StringBuilder();
		long q = input;
		
		while( q >= BASE){
			int r = (int) (q % BASE);
			q /= BASE; 
			sb.append(mp[r]);
		}
		sb.append( mp[(int) q] );
		return sb.reverse().toString();
    }
	
	// lookandsay(11,1)-->21(read as 2 1's)
	static String LookAndSay(String start, int n) {
        String astart =start;
        StringBuilder response=new StringBuilder();
		
        if(n>1){
			astart = LookAndSay(start, n-1);
		}
		
		int count = 0;
		
		char c;
		
		for(int i=0; i<astart.length(); ){
			c = astart.charAt(i);
			count++;
			int j=i+1;
			for(; j<astart.length(); j++){
				if(c == astart.charAt(j)) count++;
				else{
					break;
				}
			}
			
			response.append(count + "" + c);
			i = ( j );
			count = 0;
		}
		
		return response.toString();

    }
}

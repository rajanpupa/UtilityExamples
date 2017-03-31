package url;

public class UrlShortner {
	static int[] arr = new int[62];
	
	static void initialize(){
		for(int i=0; i<62; i++){
			if( i <10 ){
				arr[i] = i + '0';
			}else if(i>=10 && i<36){
				arr[i] = (i-10) + 'a';
			}else {
				arr[i] = (i-36) + 'A';
			}
		}
		
		for(int i=0; i<62; i++){
			System.out.print((char)arr[i] + ", ");
		}
	}
	public static void main (String[] args) {
		initialize();
		
		int a = 123459999;
		System.out.println("\nnum="+ a);
		
		int num = a;
		String enc = encode(a);
		//System.out.println("\nencode 61= " + encode(61));
		
		//enc = encode(a);
//		System.out.println("\nencode 10= " + encode(10));
//		System.out.println("\nencode 62= " + encode(62));
//		
//		System.out.println("\ndecoded 01= " + decode("01"));
//		System.out.println("\ndecoded A= " + decode("A"));
//		System.out.println("\ndecoded A= " + decode("A"));
		
		System.out.println("\nencode = " + enc);
		System.out.println("\ndecoded =" + decode(enc));
	}
	
	public static String encode(int a){
	    
	    if(a < 62){
	        return (char)arr[a] + "" ;
	    }
	    int div = a;
	    int rem = 9999;
	    
	    String code = "";
	    
	    while(div >= 62){
	       
	        rem = div %62;
	        div = div/62;
	        
	        code += (char) arr[rem];
	    }
	    
	    code += (char)arr[div];
	    
	    return code;
	}
	
	public static int decode(String a){
		
		char c;
		int temp = 0;
		int ans = 0;
		int pow = 0;
		for(int i=0; i<a.length(); i++){
			//System.out.println(a.charAt(i));
			c = a.charAt(i);
			if(c >= '0' && c<='9'){
				temp = c-'0';
			}else if(c>='a' && c<='z'){
				temp = c-'a'+10;
			}else{
				temp = c-'A'+36;
			}
			ans += temp * Math.pow(62, pow);
			pow++;
		}
		
		return ans;
	}
}

package abstraction;

public class Str {
	
	int data;
	
	public void dec(){
		class Decrementor{
			void dec(){
				data--;
			}
		}
		
		Decrementor d = new Decrementor();
		d.dec();
		System.out.println(data + "");
	}
public static void main(String[] args) {
	//ghi();
	//abc();
	int data = 0;
	Str s = new Str();
	
	s.dec();
	System.out.println();
}


private static void ghi() {
	System.out.println(new String()==new String());
	System.out.println(new String("abc")=="abc");
	System.out.println("abc"=="abc");
	try{
		
	}
	finally{
		
	}
}


public static void abc (){
	String str1 = "abc";
	String str2 = new String("abc");
	
	System.out.println(str1.hashCode() == str2.hashCode());
	System.out.println(str1.matches(str2));
	System.out.println(str1==str2);
	System.out.println(str1.equals(str2
			));
}
 

}


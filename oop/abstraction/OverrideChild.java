package abstraction;

public abstract class OverrideChild extends OverrideExample{

	public  int abc() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		int a=0, b=0;
		b= a++;
		System.out.printf("%d, %d", a, b);
		b = ++a;
		System.out.printf("%d, %d\n", a, b);
		int y = 127;
		switch(y){
			//default : System.out.println("129");
			case 127: System.out.println("127");
			case 128: System.out.println("128");
			default: System.out.println("Hello");
			case 1 : System.out.println("1");
		}
	}

}

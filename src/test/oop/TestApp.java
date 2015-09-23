package oop;

public class TestApp {
	
	public static void main(String[] args) {
		TestApp a = new TestApp3();
		a.a();//TestApp3 b;
		
	}
	public void a(){
		b();
	}
	public void b(){
		System.out.println("TestApp b;");
		
	}
}

class TestApp2 extends TestApp{
	public void b(){
		System.out.println("TestApp2 b;");
	}
}

class TestApp3 extends TestApp{
	/*public void a(){
		b();
	}*/
	public void b(){
		System.out.println("TestApp3 b;");
	}
}
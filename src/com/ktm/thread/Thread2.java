package com.ktm.thread;

public class Thread2 extends Thread{

	public static Integer repeat = 10;
	
	String message;
	
	Thread2(String message){
		this.message = message;
	}
	
	public void run(){
		for(int i = 0; i<repeat; i++){
			System.out.println(message);
			try{
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1(){
		Thread2 t2 = new Thread2("This is thread 1");
		Thread2 t3 = new Thread2("2");
		
		t2.start();
		t3.start();
		
		for(int i = 0; i < repeat ; i++){
			System.out.println("Hello world! Main Thread");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("Hello World");
			}
		}
		
	}
	
}

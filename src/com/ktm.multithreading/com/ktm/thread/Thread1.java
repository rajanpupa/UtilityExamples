package com.ktm.thread;

public class Thread1 implements Runnable{

	public static Integer repeat = 10;
	String message;
	//@FoldRegion("abc")
	//{{section1
	Thread1(String abc){
		this.message = abc;
	}
	//section1}}
	//@EndRegion()
	//<editor-fold defaultstate="collapsed" desc="run methods">
	/**
	 * @author i80991
	 */
	//{{{
	/**
	 * abc
	 */
	//}}}
	@Override
	public void run() {
		for(int i=0; i<repeat ; i++){
			System.out.println("Hello World! " + message);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		test2();
	}
	//</editor-fold>

	public static void test2(){
		Runnable thread1 = new Thread1("Thread1");
		Runnable thread2 = new Thread1("Thread2");
		
		Thread thr1 = new Thread(thread1);
		Thread thr2 = new Thread(thread2);
		
		thr1.start();
		thr2.start();
		
		for(int i = 0; i < repeat ; i++){
			System.out.println("Hello world! Main Thread");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("Hello World");
			}
		}
	}

	public static void test1(){
		Runnable thread1 = new Thread1("Thread1");
		Runnable thread2 = new Thread1("Thread2");
		
		thread1.run();
		thread2.run();
		
		for(int i = 0; i < repeat ; i++)
			System.out.println("Hello world2!");
	}
}

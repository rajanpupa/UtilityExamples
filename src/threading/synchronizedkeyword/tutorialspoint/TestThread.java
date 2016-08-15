package synchronizedkeyword.tutorialspoint;

import java.util.ArrayList;
import java.util.List;

class PrintDemo{
	public void printCount(){
		try{
			for(int i=0; i<5; i++){
				System.out.println("Counter ---- " + i);
			}
		}catch(Exception e){
			System.out.println("Thread interrupted");
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		PrintDemo PD = new PrintDemo();
		
		List<Thread> demos = new ArrayList<Thread>();
		int numThreads = 5;
		
		for (int i=0; i<5; i++){
			Thread t = new ThreadDemo("Thread - " + i, PD);
			demos.add(t);
		}
		
		for (Thread t: demos){
			t.start();
		}
		
		try{
			for (Thread t: demos){
				t.join();
			}
		}catch (Exception e){
			System.out.println("interrupted.");
		}
	}
}

class ThreadDemo extends Thread{
	private Thread t;
	private String threadName;
	PrintDemo PD;
	
	ThreadDemo(String name, PrintDemo pd){
		threadName = name;
		PD = pd;
	}
	public void run(){
		synchronized(PD) {
			System.out.println("Starting "+ threadName);
			PD.printCount();
			System.out.println("Thread " + threadName + " exiting.");
		}
		
	}
	public void start(){
		
		if(t==null){
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

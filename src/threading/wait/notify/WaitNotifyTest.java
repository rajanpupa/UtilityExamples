package wait.notify;

public class WaitNotifyTest {
	 
	/**
	 * http://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
	 * @param args
	 */
    public static void main(String[] args) {
        Message msg = new Message("process it");
        
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();
         
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();
         
        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        
        System.out.println("\nAll the threads are started");
    }
 
}
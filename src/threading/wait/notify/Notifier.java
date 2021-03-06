package wait.notify;

public class Notifier implements Runnable {
	 
    private Message msg;
     
    public Notifier(Message msg) {
        this.msg = msg;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"=> started\n");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+"=> has changed the original message before notifying.");
                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
    }
 
}
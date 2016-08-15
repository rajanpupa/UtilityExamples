# Synchronized

```
	public void run(){
		synchronized(PD) {
			System.out.println("Starting "+ threadName);
			PD.printCount();
			System.out.println("Thread " + threadName + " exiting.");
		}
		
	}
```

* In the above method, since same instance of `PD` is passed on all the threads, so PD works as a common lock.
* Any thread which has entered the synchronized block above, exits before any other thread begine executing the same block of code.

### NOTE
* Synchronization should be done by locking on a common Object. If different instance of `PD` were passed on the above code, all the thread invoking the run method would have run.

## Synchronization

	* Java synchronized code will only be executed by one thread at a time.
	* The `synchronized` keyword in java provides locking, which ensures mutually exclusive access to the shared resources and prevents data race.
	* It also prevent reordering of code statement by the compiler which can cause a subtle concurrent issue if we don't use synchronized or volatile keyword.
	* `synchronized` keyword involve locking and unlocking. before entering into synchronized block, thread needs to acquire lock, at this point it reads data from main memory then cache and when it release the lock, it flushes write operation into main memory which eliminates memory inconsistency errors.
	* can have both static synchronized method and nonstatic synchronized method and synchronized blocks in Java but we can not have synchronized variable in java
	* `volatile` keyword instructs jvm to read from main memory and not cache it.
	* Block synchronization is better than method synchronization because, only critical section could be locked instead of the whole method.
	* static block synchronization will lock the class, while non-static block synchronization will lock on current object.
	* Java synchronized keyword is re-entrant in nature it means if a java synchronized method calls another synchronized method which requires the same lock then the current thread which is holding lock can enter into that method without acquiring the lock.
	* Java.util.concurrent.locks extends capability provided by java synchronized keyword for writing more sophisticated programs since they offer more capabilities e.g. Reentrancy and interruptible locks.
	* Do not synchronize on the non-final field on synchronized block in Java

```
private String lock = new String("lock"); 

synchronized(lock){ 
	System.out.println("locking on :" + lock); 
}

```


### References:
Read more: http://javarevisited.blogspot.com/2011/04/synchronization-in-java-synchronized.html#ixzz4HPm0TnoU
	
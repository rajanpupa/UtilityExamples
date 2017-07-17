# Java Threading

## States
	* Created
	* Runnable
	* Running
	* Waiting
	* Dead


 ## Synchronized Block
 
 * Callable is like Runnable and can return a value at the end of execution.
 * Thread Executor Service can be used to execute any threads.
 * Executor service's methods can be used to get the result, or check the status of the thread
 
## Yield vs join

* Yield hints the scheduler that the thread is willing to give another thread chance to execute.
* yield() can be ignored by the scheduler.
* Current thread can go from running to runnable state. Not wait state.
	
## References

[Yield vs Join](http://howtodoinjava.com/core-java/multi-threading/difference-between-yield-and-join-in-threads-in-java/)

[Multithreading Interview questions](http://www.journaldev.com/1162/java-multithreading-concurrency-interview-questions-answers)

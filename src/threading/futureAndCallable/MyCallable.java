package futureAndCallable;

import java.util.concurrent.Callable;

/*
 * Callable runs in different thread and returns a value as well (Generics)
 * 
 * Reference:
 * http://www.vogella.com/tutorials/JavaConcurrency/article.html#futures
 */

public class MyCallable implements Callable<Long> {
	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (long i = 0; i <= 100; i++) {
			sum += i;
		}
		//DELAY
		Thread.sleep(100);
			
		return sum;
	}

}

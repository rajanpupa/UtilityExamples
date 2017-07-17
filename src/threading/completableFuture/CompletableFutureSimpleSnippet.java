package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
 * CompletableFuture extends the functionality of the Future interface for asynchronous calls.
 * It also implements the CompletionStage interface.
 * CompletionStage offers methods, that let you attach callbacks that will be executed on completion.
 * 
 */
public class CompletableFutureSimpleSnippet {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        // configure CompletableFuture
        CompletableFuture<Integer> futureCount = createCompletableFuture();

            // continue to do other work
            System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds" );

            // now its time to get the result
            try {
              int count = futureCount.get();
                System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );

               System.out.println("Result " + count);
             } catch (InterruptedException | ExecutionException ex) {
                // Exceptions from the future should be handled here
            }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
                () -> {
                    try {
                    	System.out.println("-----Thread started-----");
                        // simulate long running task
                        Thread.sleep(5000);
                    } catch (InterruptedException e) { }
                    return 20;
                });
        return futureCount;
    }

}

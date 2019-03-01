import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class test_thread1 {
	public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException {
		/*Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};
		
		task.run();

		Thread thread = new Thread(task);
		thread.start();
		Thread thread1 = new Thread(task);
		thread1.start();
		System.out.println("Done!");*/
		
		/*Runnable task = () -> {
			try {
				String threadname = Thread.currentThread().getName();
				System.out.println("Foo " + threadname);
				Thread.sleep(1000);
				System.out.println("Bar " + threadname);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Thread thread = new Thread(task);
		thread.start();*/
		
				// ---------- ExecutorService  ------------------
		/*ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			try {
			    System.out.println("attempt to shutdown executor");
			    executor.shutdown();
			    executor.awaitTermination(5, TimeUnit.SECONDS);
			}
			catch (InterruptedException e) {
			    System.err.println("tasks interrupted");
			}
			finally {
			    if (!executor.isTerminated()) {
			        System.err.println("cancel non-finished tasks");
			    }
			    executor.shutdownNow();
			    System.out.println("shutdown finished");
			}

		});*/
		
				//---------------------- Callable ------------------------
		/*Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		System.out.println("future done? " + future.isDone());
		Integer result = future.get(2, TimeUnit.SECONDS);
		//executor.shutdownNow();
		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);*/  
		
		/*ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
				 callable("task1", 2),
				 callable("task2", 1),
				 callable("task3", 3));

		executor.invokeAll(callables).stream().map(future -> {
		        try {
		            return future.get();
		        }
		        catch (Exception e) {
		            throw new IllegalStateException(e);
		        }
		    }) .forEach(System.out::println);
		String result = executor.invokeAny(callables);
		System.out.println(result);*/
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
		ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

		TimeUnit.MILLISECONDS.sleep(1337);

		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms", remainingDelay);

		
	}
	private static Callable<String> callable(String result, long sleepSeconds) {
	    return () -> {
	        TimeUnit.SECONDS.sleep(sleepSeconds);
	        return result;
	    };
	}
}

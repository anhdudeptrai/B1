import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test_thread2 {
	public static void main(String args[]) {
		
		Runnable task = ()-> {
			String namethread = Thread.currentThread().getName();
			System.out.println("Run with " + namethread);
		};
		ExecutorService pool = Executors.newFixedThreadPool(10);
		pool.execute(task);
		pool.execute(task);
		pool.execute(task);
		pool.shutdown();
		
	}
}

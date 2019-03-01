import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test_runnable_1 {
	public static void main(String args[]) {
		String st1 = new String("an choi ngu nghi xa hoi");
		String st2 = new String("choi choi an ngu nghi hoc tap");
		Runnable1 task1 = new Runnable1(st1);
		Runnable1 task2 = new Runnable1(st2);
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.execute(task1);
		pool.execute(task2);
		pool.shutdown();
		while (!pool.isTerminated());
		System.out.println(task1.map);
		System.out.println(task2.map);
	}
}

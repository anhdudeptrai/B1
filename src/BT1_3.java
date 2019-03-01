import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BT1_3 {
	public static void main(String args[]) throws InterruptedException {
		Map<String, Integer> dict = new HashMap<String, Integer>();
		File dir = new File("/home/dutrinh/eclipse-workspace/input");
		String []files = dir.list();
		
		int L = files.length; 			// so luong file	=  10
		
		Runnable2 tasks[] = new Runnable2[L];
		ExecutorService pool = Executors.newFixedThreadPool(4);
			for (int i = 0; i<L; i++) {
				tasks[i] = new Runnable2("/home/dutrinh/eclipse-workspace/input/" + files[i]);
				pool.execute(tasks[i]);
			}
		pool.shutdown();
		while (!pool.isTerminated());
		for (Runnable2 task:tasks) {
			Set<String> keys = task.map.keySet();
			for (String key: keys) 
				if (dict.get(key)==null) dict.put(key, task.map.get(key));
				else dict.put(key, dict.get(key)+task.map.get(key));
		}
		System.out.println(dict);
		
	}
}

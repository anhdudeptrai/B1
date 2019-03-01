import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BT1_2 {
	public static void main(String args[]) throws InterruptedException {
		Map<String, Integer> dict = new HashMap<String, Integer>();
		ExecutorService pool = Executors.newFixedThreadPool(2);
		try {
			FileReader fr = new FileReader("/home/dutrinh/eclipse-workspace/input.txt");
			FileWriter fw = new FileWriter("/home/dutrinh/eclipse-workspace/output.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			ArrayList<Runnable1> tasks = new ArrayList<Runnable1>();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				Runnable1 task = new Runnable1(line);
				pool.execute(task);
				tasks.add(task);
				//Thread.sleep(10);
			}
				pool.shutdown();
				while (!pool.isTerminated());
			for (Runnable1 task:tasks) {
				Set<String> keys = task.map.keySet();
				for (String key: keys) 
					if (dict.get(key)==null) dict.put(key, task.map.get(key));
					else dict.put(key, dict.get(key)+task.map.get(key));
			}
				
			
			Set<String> keySet = dict.keySet();
			for (String key : keySet) 
				fw.write(key + " " + dict.get(key) + " \n");		
			fr.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error : " + e);
		}
		System.out.println(dict);

	}
}

import java.util.HashMap;

public class Runnable1 implements Runnable{
	public String line;
	public HashMap<String, Integer> map = new HashMap<String, Integer>();
	public Runnable1(String line) {
		this.line = line;
	}

	@Override
	public void run() {	
		String[] str_line = this.line.toLowerCase().split(" ");
		//HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String str: str_line)
			if (map.get(str)==null) map.put(str, 1);
			else map.put(str, map.get(str)+1);
		
	}
	
}

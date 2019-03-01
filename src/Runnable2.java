import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Runnable2 implements Runnable{
	public String link;
	public HashMap<String, Integer> map = new HashMap<String, Integer>();
	public Runnable2(String link) {
		this.link = link;
	}

	@Override
	public void run() {	
		try {
			FileReader fr = new FileReader(new File(link));
			BufferedReader br = new BufferedReader(fr);
			String line; String[] str_line;
			while ((line=br.readLine())!=null) {
				str_line = line.toLowerCase().split(" ");
				for (String str: str_line)
					if (map.get(str)==null) map.put(str, 1);
					else map.put(str, map.get(str)+1);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
	}
	
}

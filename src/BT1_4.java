import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BT1_4 {
	
	public static double norm2(Point2 p1, Point2 p2) {
		return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
	}
	
	public static void main(String args[]) {
		Point2 A = new Point2(800, 800);
		Point2 B = new Point2(4000, 800);
		Point2 C = new Point2(2400, 2400);
		Random rd = new Random();
		
		Set<Point2> setPoint = new HashSet<Point2>();
		while (setPoint.size()!=8000) {
			Point2 p = new Point2(400+rd.nextInt(801), 400+rd.nextInt(801));
			if (norm2(A, p)<=400) setPoint.add(p);
		}
		while (setPoint.size()!=18000) {
			Point2 p = new Point2(3500+rd.nextInt(1001), 300+rd.nextInt(1001));
			if (norm2(B, p)<=500) setPoint.add(p);
		}
		while (setPoint.size()!=30000) {
			Point2 p = new Point2(1800+rd.nextInt(1201), 1800+rd.nextInt(1201));
			if (norm2(C, p)<=600) setPoint.add(p);
		}
		//Set<Integer> pos = new HashSet<Integer>();
		try {
			FileWriter fw = new FileWriter("/home/dutrinh/eclipse-workspace/output4.txt");
			for (Point2 p:setPoint) fw.write(p.x + " " + p.y + "\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

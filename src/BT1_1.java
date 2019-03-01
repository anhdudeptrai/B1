import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BT1_1 {
	public static void main(String args[]) {
		Random rd = new Random();
		Set<Integer> A = new HashSet<Integer>();
		Set<Integer> B = new HashSet<Integer>();
		
		Set<Integer> C = new HashSet<Integer>();
		Set<Integer> D = new HashSet<Integer>();
		while (A.size()!=10) A.add(rd.nextInt(19));
		while (B.size()!=10) B.add(rd.nextInt(19));
		C.addAll(A); C.addAll(B);
		for (Integer p: A)
			for (Integer q: B) 
				if (p==q) D.add(p);
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		System.out.println(D);
	
	}
	
}

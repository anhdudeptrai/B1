import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class test_equals_hashcode {
	public static void main(String args[]) {
		/*Student student1 = new Student("123", "Tom", "tom@gmail.com", 30);
		Student student2 = new Student("123", "Tom", "tom@gmail.com", 30);
		Student student3 = new Student("456", "Peter", "peter@gmail.com", 23);
		 
		Set<Student> setStudents = new HashSet<Student>();
		 
		setStudents.add(student1);
		setStudents.add(student2);
		setStudents.add(student3);*/
		
		/*List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println(names);*/
		
		/*Processor stringProcessor = str -> str.length();
	    String name = "Java Lambda";
	    int length = stringProcessor.getStringLength(name);
	    System.out.println(length);
	    */
		
		System.out.println(isPrime(4));
				
	}
	
	private static boolean isPrime(int number) {        
	    return number > 1
	            && IntStream.range(2, number).noneMatch(
	                    index -> number % index == 0);
	}
	
}

@FunctionalInterface
interface Processor {
  int getStringLength(String str);
}

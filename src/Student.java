
public class Student {
	private String id;
    private String name;
    private String email;
    private int age;
 
    public Student(String id) {
        this.id = id;
    }
 
    public Student(String id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
 
    public String toString() {
        String studentInfo = "Student " + id;
        studentInfo += ": " + name;
        studentInfo += " - " + email;
        studentInfo += " - " + age;
 
        return studentInfo;
    }
 
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student another = (Student) obj;
            if (this.id.equals(another.id)) return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 31 + id.hashCode();
    }
    
}

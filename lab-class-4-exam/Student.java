public class Student extends Person {
    protected String studentId;
    protected String major;
    
    public Student(String name, int age, String studentId, String major) {
        super(name, age);
        this.studentId = studentId;
        this.major = major;
    }
    
    public void displayStudentInfo() {
        super.displayInfo();  
        System.out.println("Student ID: " + studentId);
        System.out.println("Major: " + major);
    }
}

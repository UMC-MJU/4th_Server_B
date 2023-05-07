public class Student {
    private String name;
    private int studentId;
    private String major;
    
    public Student (String name, int studentId, String major){
        this.name = name;
        this.studentId = studentId;
        this.major = major;
    }
    
    public void print(){
        System.out.println("name = " + name);
        System.out.println("studentId = " + studentId);
        System.out.println("major = " + major);
    }
}

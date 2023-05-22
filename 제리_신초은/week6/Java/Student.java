package Java;

//학생(Student) 클래스를 작성해보세요. 학생 클래스는 이름(name), 학번(studentID), 전공(major) 멤버 변수를 가지며,
//생성자와 정보를 출력하는 메서드를 작성하세요.
public class Student {
    String name;
    int studentID;
    String major;

    //Student 생성자
    public Student(String name, int studentID, String major) {
        this.name = name;
        this.studentID = studentID;
        this.major = major;
    }

    //Student 출력 메소드
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
        System.out.println("Major: " + major);
    }
}

// 학생(Student) 클래스를 작성해보세요. 학생 클래스는 이름(name), 학번(studentID), 전공(major) 멤버 변수를 가지며, 생성자와 정보를 출력하는 메서드를 작성하세요.
public class Student {

    // 생성자
    public Student(String name, Long studentID, String major) {
        this.name = name;
        this.studentID = studentID;
        this.major = major;
    }

    private String name; // 이름
    private Long studentID; // 학번
    private String major; // 전공

    public String getName() {
        return name;
    }

    public Long getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    // 정보 출력
    public String getInfo() {
        return "이름: " + this.getName() + "/학번: " + this.getStudentID() + "/전공: " + this.getMajor();
    }
}

package Java;
//학생 객체를 생성하고, 정보를 출력해보세요.
public class StudentMain {
    public static void main(String[] args) {
        //객체 생성
        Student student = new Student("신초은", 60202214, "컴퓨터공학과");
        //출력 메소드 호출
        student.printInfo();
    }
}

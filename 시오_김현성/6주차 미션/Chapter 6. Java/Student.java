public class Student {
    String name;
    String studentID;
    String major;

    public Student(String name , String studentID, String major){
        this.name = name;
        this.studentID = studentID;
        this.major = major;
    }
    public void showInfo(){
        System.out.print("이름은 " +name+" 학번은 "+studentID+" 전공은 "+major);
    }

    public static void main(String args[]){

        Student st = new Student("김현성","60215206","컴퓨터공학과");

       st.showInfo();
    }

}

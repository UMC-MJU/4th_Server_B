package Java;
//숫자를 입력받아 10으로 나눈 값을 출력하는 프로그램을 작성하세요.
//예외 처리를 이용하여, 0으로 나누려는 경우 "Cannot divide by zero"라는 메시지를 출력하세요.
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //Scanner 객체 생성
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();    //정수 입력받기
        scanner.close();
        //try-catch문 사용해 예외 처리
        try {
            int result = num / 10;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {           //ArithmeticException 예외 잡기
            System.out.println("Cannot divide by zero");
        }
    }
}

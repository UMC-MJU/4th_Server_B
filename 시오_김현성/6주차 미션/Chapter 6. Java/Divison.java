import java.util.Scanner;

public class Divison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        try {
            int result = num / 10;
            System.out.println(result);
        } catch (ArithmeticException e) {//산술연산에서 정수를 0으로 나누는 연산을 수행할수 없는 오류가 발생한경우 처리하는 예외 클래스
            System.out.println("Cannot divide by zero");
        }
    }
}

package week5.반복문;
// 반복문 3번 문제
import java.util.Scanner;
//백준 프로그래밍 연습 클래스
public class B8393 {
    //백준 프로그래밍 연습 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	//Scanner 객체 선언
        int num;	//입력받을 정수 n
        int sum = 0;	//1부터 n까지의 합

        num = sc.nextInt();

        for(int i = 0; i < num; i++)
        {
            sum += i+1;
        }

        System.out.println(sum);
    }
}

package week5.조건문;

// 조건문 4번 문제
import java.util.Scanner;
//백준 프로그래밍 연습 클래스
public class B14681 {
    //백준 프로그래밍 연습 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	//Scanner 객체 선언
        int x, y; //주어진 점의 x좌표, y좌표

        x = sc.nextInt();
        y = sc.nextInt();

        if(x > 0)
        {
            if(y > 0)
                System.out.println(1);
            else
                System.out.println(4);
        }
        else
        {
            if(y>0)
                System.out.println(2);
            else
                System.out.println(3);
        }

    }

}
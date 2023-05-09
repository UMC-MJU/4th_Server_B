package week5.조건문;
// 조건문 3번 문제
import java.util.Scanner;
//백준 프로그래밍 연습 클래스
public class B2753 {
    //백준 프로그래밍 연습 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	//Scanner 객체 선언
        int year; //입력받을 연도
        year = sc.nextInt();	//연도 입력받기

        if(year%4==0 && year%100!=0)	//윤년일 때
        {
            System.out.println(1);
        }
        else if(year%4==0 && year%400==0)
        {
            System.out.println(1);
        }
        else	//윤년이 안리 때
        {
            System.out.println(0);
        }

    }

}
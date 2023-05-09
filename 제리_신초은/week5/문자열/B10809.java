// 문자열 6번째 문제
package week5.문자열;

import java.util.Scanner;
//10809번을 풀기 위한 메인 클래스
public class B10809 {
    //10809번을 풀기 위한 메인 메소드
    public static void main(String[] args) {
        //Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        //출력 횟수 입력받기
        String word = sc.next();

        //아스키코드 a~z까지
        for (int i = 97 ; i < 123 ; i++) {
            //아스키코드 문자열로 변환
            String j = String.valueOf((char) i);
            //문자열에 j가 포함되어있다면 index 출력
            if (word.contains(j)) {
                System.out.print(String.valueOf(word.indexOf(j)));
            } else {
                //아니면 -1 출력
                System.out.print(-1);
            }
            System.out.print(" ");
        }

    }
}

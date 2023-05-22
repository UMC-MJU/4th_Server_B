// 문자열 3번 문제
package week5.문자열;

import java.util.Scanner;

//9086번을 풀기 위한 메인 클래스
public class B9086 {
    //9086번을 풀기 위한 메인 메소드
    public static void main(String[] args) {
        //Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        //출력 횟수 입력받기
        int N = sc.nextInt();

        for (int i = 0 ; i < N ; i++) {
            String a = sc.next();
            int l = a.length(); //입력받은 문자열 길이 저장
            String f_c = String.valueOf(a.charAt(0));   //charAt()을 사용애서 첫번째 문자 출력
            String l_c = String.valueOf(a.charAt(l-1)); //charAt()을 사용해서 마지막 문자 출력
            System.out.println(f_c+l_c);
        }

    }
}

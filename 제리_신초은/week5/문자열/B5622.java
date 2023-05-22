// 문자열 10번째 문제
package week5.문자열;

import java.io.IOException;

//5622번을 풀기 위한 메인 클래스
public class B5622 {
    //5622번을 풀기 위한 메인 메소드
    public static void main(String[] args) throws IOException {

        int count = 0;  //총 시간을 저장할 변수
        int value;      //각 문자를 저장할 변수

        while(true) {
            //문자 횟수 입력받기
            value = System.in.read();

            //문자가 끝나면 반복문도 종료
            if(value == '\n') {
                break;
            }

            //아스키코드값으로 구분
            if(value < 68) count += 3;
            else if(value < 71) count += 4;
            else if(value < 74) count += 5;
            else if(value < 77) count += 6;
            else if(value < 80) count += 7;
            else if(value < 84) count += 8;
            else if(value < 87) count += 9;
            else count += 10;
        }
        System.out.print(count);
    }
}
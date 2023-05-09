package week5.일차원배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
//1546번을 풀기 위한 메인 클래스
public class B1546 {
    //1546번을 풀기 위한 메인 메소드

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Scanner 객체 선언

        int num = sc.nextInt();	//세준이가 본 과목의 개수
        List<Integer> score = new ArrayList<Integer>();	//나머지 저장할 리스트 remain 선언
        for(int i = 0; i < num ; i++)	//과목 수만큼 성적 리스트에 입력받기
        {
            score.add(sc.nextInt());
        }
        Collections.sort(score);	//리스트 오름차순 정리하기
        float max = score.get(num-1);	//리스트에서 최댓값 max에 저장

        float sum = 0;				//평균을 위한 합을 구할 변수 선언
        for(int i = 0; i < num ; i++)	//세준이가 바꾼 값을 모두 sum에 더하기
        {
            sum += score.get(i)*100/max;
        }
        System.out.println(sum/num);

    }

}

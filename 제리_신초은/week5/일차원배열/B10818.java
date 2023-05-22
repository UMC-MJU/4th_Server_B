package week5.일차원배열;

// 1차원 배열 3번 문제
import java.util.Scanner;
//10818번을 풀기 위한 메인 클래스
public class B10818 {
    //10818번을 풀기 위한 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Scanner 객체 선언

        int N;	//입력받을 배열의 개수
        N = sc.nextInt();
        int min = -1000000, max = 1000000; 	//최솟값, 최댓값

        int[] array = new int[N];

        for(int i = 0; i < N ; i++)
        {
            array[i] = sc.nextInt();
        }

        min = array[0];
        max = array[0];
        //System.out.println(array);
        for(int i = 0; i < N-1 ; i++)
        {
            if(min > array[i+1])	{ min = array[i+1]; }
            if(max < array[i+1])	{ max = array[i+1];	}
        }

        System.out.println(min +" "+max);
    }
}
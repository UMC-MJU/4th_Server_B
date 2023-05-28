package week5.이차원배열;

import java.util.Scanner;

//2563번을 풀기 위한 메인 클래스
public class B2563 {
    //2563번을 풀기 위한 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Scanner 객체 선언
        int N = sc.nextInt();	//입력받을 색종이 개수

        //0으로 채워진 색종이 100x100 만들기
        int[][] array = new int[100][100];

        int count = 0;

        //N번 반복
        for(int i = 0; i < N ; i++) {
            //x와 y 값 입력받기
            int X = sc.nextInt();
            int Y = sc.nextInt();

            //시작 좌표부터 10을 더한 값까지 1로 바꿔주기
            for(int a = X; a < X+10; a++) {
                for (int b = Y; b < Y+10; b++) array[a][b] = 1;
            }
        }

        //배열에 1이 저장된 개수를 저장
        for(int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(array[i][j] == 1) count++;
            }
        }

        System.out.println(count);

    }
}

package week5.반복문;
// 반복문 10번 문제
import java.io.*;
//백준 for문을 풀기 위한 메인 클래스
public class B2439 {
    //백준 for문을 풀기 위한 메인 메소드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st;

        //예외처리는 필수. throws IOException을 해줘야 함. 이클립스에 작성하면 빨간 줄 뜨는데
        //마우스 가져다 대면 자동으로 작성된다.
        int num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= num ; i++)
        {
            int r;
            for(r = 1; r <= num - i; r++)
            {
                bw.write(" ");
            }
            for(r = 1;r <= i; r++)
            {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

}